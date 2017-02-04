/*
 * Copyright 2017 Gregory P. Moyer
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.syphr.lametrictime.api.local.impl;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.SortedMap;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.filter.LoggingFilter;
import org.syphr.lametrictime.api.cloud.impl.LaMetricTimeCloudImpl;
import org.syphr.lametrictime.api.common.impl.AbstractClient;
import org.syphr.lametrictime.api.local.ApplicationActionException;
import org.syphr.lametrictime.api.local.ApplicationActivationException;
import org.syphr.lametrictime.api.local.ApplicationNotFoundException;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.LocalConfiguration;
import org.syphr.lametrictime.api.local.NotificationCreationException;
import org.syphr.lametrictime.api.local.NotificationNotFoundException;
import org.syphr.lametrictime.api.local.UpdateException;
import org.syphr.lametrictime.api.local.model.Api;
import org.syphr.lametrictime.api.local.model.Application;
import org.syphr.lametrictime.api.local.model.Audio;
import org.syphr.lametrictime.api.local.model.AudioUpdateResult;
import org.syphr.lametrictime.api.local.model.Bluetooth;
import org.syphr.lametrictime.api.local.model.BluetoothUpdateResult;
import org.syphr.lametrictime.api.local.model.Device;
import org.syphr.lametrictime.api.local.model.Display;
import org.syphr.lametrictime.api.local.model.DisplayUpdateResult;
import org.syphr.lametrictime.api.local.model.Failure;
import org.syphr.lametrictime.api.local.model.Notification;
import org.syphr.lametrictime.api.local.model.NotificationResult;
import org.syphr.lametrictime.api.local.model.UpdateAction;
import org.syphr.lametrictime.api.local.model.WidgetUpdates;
import org.syphr.lametrictime.api.local.model.Wifi;

import com.eclipsesource.jaxrs.provider.gson.GsonProvider;
import com.google.gson.reflect.TypeToken;

public class LaMetricTimeLocalImpl extends AbstractClient implements LaMetricTimeLocal
{
    private static final String HEADER_ACCESS_TOKEN = "X-Access-Token";

    private final LocalConfiguration config;

    private volatile Api api;

    public LaMetricTimeLocalImpl(LocalConfiguration config)
    {
        this.config = config;
    }

    @Override
    public Api getApi()
    {
        if (api == null)
        {
            synchronized (this)
            {
                if (api == null)
                {
                    api = getClient().target(config.getBaseUri())
                                     .request(MediaType.APPLICATION_JSON_TYPE)
                                     .get(Api.class);
                }
            }
        }

        return api;
    }

    @Override
    public Device getDevice()
    {
        return getClient().target(getApi().getEndpoints().getDeviceUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Device.class);
    }

    @Override
    public String createNotification(Notification notification) throws NotificationCreationException
    {
        Response response = getClient().target(getApi().getEndpoints().getNotificationsUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(notification));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new NotificationCreationException(response.readEntity(Failure.class));
        }

        try
        {
            return response.readEntity(NotificationResult.class).getSuccess().getId();
        }
        catch (Exception e)
        {
            throw new NotificationCreationException("Invalid JSON returned from service", e);
        }
    }

    @Override
    public List<Notification> getNotifications()
    {
        Response response = getClient().target(getApi().getEndpoints().getNotificationsUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .get();

        // @formatter:off
        return getGson().fromJson(response.readEntity(String.class),
                                  new TypeToken<List<Notification>>(){}.getType());
        // @formatter:on
    }

    @Override
    public Notification getCurrentNotification()
    {
        Notification notification = getClient().target(getApi().getEndpoints()
                                                               .getCurrentNotificationUrl())
                                               .request(MediaType.APPLICATION_JSON_TYPE)
                                               .get(Notification.class);

        // when there is no current notification, return null
        if (notification.getId() == null)
        {
            return null;
        }

        return notification;
    }

    @Override
    public Notification getNotification(String id) throws NotificationNotFoundException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getConcreteNotificationUrl()
                                                       .replace("{/:id}", "/" + id))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .get();

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new NotificationNotFoundException(response.readEntity(Failure.class));
        }

        return response.readEntity(Notification.class);
    }

    @Override
    public void deleteNotification(String id) throws NotificationNotFoundException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getConcreteNotificationUrl()
                                                       .replace("{/:id}", "/" + id))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .delete();

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new NotificationNotFoundException(response.readEntity(Failure.class));
        }

        response.close();
    }

    @Override
    public Display getDisplay()
    {
        return getClient().target(getApi().getEndpoints().getDisplayUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Display.class);
    }

    @Override
    public Display updateDisplay(Display display) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getDisplayUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .put(Entity.json(display));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }

        return response.readEntity(DisplayUpdateResult.class).getSuccess().getData();
    }

    @Override
    public Audio getAudio()
    {
        return getClient().target(getApi().getEndpoints().getAudioUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Audio.class);
    }

    @Override
    public Audio updateAudio(Audio audio) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getAudioUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .put(Entity.json(audio));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }

        return response.readEntity(AudioUpdateResult.class).getSuccess().getData();
    }

    @Override
    public Bluetooth getBluetooth()
    {
        return getClient().target(getApi().getEndpoints().getBluetoothUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Bluetooth.class);
    }

    @Override
    public Bluetooth updateBluetooth(Bluetooth bluetooth) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getBluetoothUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .put(Entity.json(bluetooth));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }

        return response.readEntity(BluetoothUpdateResult.class).getSuccess().getData();
    }

    @Override
    public Wifi getWifi()
    {
        return getClient().target(getApi().getEndpoints().getWifiUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Wifi.class);
    }

    @Override
    public void updateApplication(String packageName,
                                  String accessToken,
                                  WidgetUpdates widgetUpdates) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getWidgetUpdateUrl()
                                                       .replace("{/:id}", "/" + packageName))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .header(HEADER_ACCESS_TOKEN, accessToken)
                                       .post(Entity.json(widgetUpdates));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }

        response.close();
    }

    @Override
    public SortedMap<String, Application> getApplications()
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getAppsListUrl()
                                                       .replace("/v2device/", "/v2/device/"))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .get();

        // @formatter:off
        return getGson().fromJson(response.readEntity(String.class),
                                  new TypeToken<SortedMap<String, Application>>(){}.getType());
        // @formatter:on
    }

    @Override
    public Application getApplication(String packageName) throws ApplicationNotFoundException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getAppsGetUrl()
                                                       .replace("/v2device/", "/v2/device/")
                                                       .replace("{:id}", packageName))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .get();

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new ApplicationNotFoundException(response.readEntity(Failure.class));
        }

        return response.readEntity(Application.class);
    }

    @Override
    public void activatePreviousApplication()
    {
        getClient().target(getApi().getEndpoints().getAppsSwitchPrevUrl().replace("/v2device/",
                                                                                  "/v2/device/"))
                   .request(MediaType.APPLICATION_JSON_TYPE)
                   .put(Entity.json(new Object()));
    }

    @Override
    public void activateNextApplication()
    {
        getClient().target(getApi().getEndpoints().getAppsSwitchNextUrl().replace("/v2device/",
                                                                                  "/v2/device/"))
                   .request(MediaType.APPLICATION_JSON_TYPE)
                   .put(Entity.json(new Object()));
    }

    @Override
    public void activateApplication(String packageName,
                                    String widgetId) throws ApplicationActivationException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getAppsSwitchUrl()
                                                       .replace("/v2device/", "/v2/device/")
                                                       .replace("{:id}", packageName)
                                                       .replace("{:widget_id}", widgetId))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .put(Entity.json(new Object()));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new ApplicationActivationException(response.readEntity(Failure.class));
        }

        response.close();
    }

    @Override
    public void doAction(String packageName,
                         String widgetId,
                         UpdateAction action) throws ApplicationActionException
    {
        Response response = getClient().target(getApi().getEndpoints()
                                                       .getAppsActionUrl()
                                                       .replace("/v2device/", "/v2/device/")
                                                       .replace("/actions/", "/action/")
                                                       .replace("{:id}", packageName)
                                                       .replace("{:widget_id}", widgetId))
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(action));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new ApplicationActionException(response.readEntity(Failure.class));
        }

        response.close();
    }

    @Override
    protected Client createClient()
    {
        ClientBuilder builder = ClientBuilder.newBuilder();

        // setup Gson (de)serialization
        GsonProvider<Object> gsonProvider = new GsonProvider<>();
        gsonProvider.setGson(getGson());
        builder.register(gsonProvider);

        /*
         * The certificate presented by LaMetric time is self-signed and the
         * host will likely not match the network configuration where the user
         * has the device connected. Therefore, unless the user takes action
         * (i.e. adding the certificate chain to the Java keystore and dealing
         * with the hostname mismatch), HTTPS will fail.
         *
         * By setting the checkCertificate configuration option to false
         * (default), HTTPS will be used and the connection will be encrypted,
         * but the validity of the certificate is not confirmed.
         */
        if (config.isSecure() && !config.isCheckCertificate())
        {
            try
            {
                SSLContext sslcontext = SSLContext.getInstance("TLS");
                sslcontext.init(null, new TrustManager[] { new X509TrustManager()
                {
                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException
                    {
                        // noop
                    }

                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0,
                                                   String arg1) throws CertificateException
                    {
                        // noop
                    }

                    @Override
                    public X509Certificate[] getAcceptedIssuers()
                    {
                        return new X509Certificate[0];
                    }

                } }, new java.security.SecureRandom());
                builder.sslContext(sslcontext);
            }
            catch (KeyManagementException | NoSuchAlgorithmException e)
            {
                throw new RuntimeException("Failed to setup secure communication", e);
            }

            // disable the hostname verifier as well since the certificate will not have this information
            builder.hostnameVerifier((host, session) -> true);
        }

        // turn on logging if requested
        if (config.isLogging())
        {
            builder.register(new LoggingFilter(Logger.getLogger(LaMetricTimeCloudImpl.class.getName()),
                                               config.getLogMax()));
        }

        // setup basic auth
        builder.register(HttpAuthenticationFeature.basic(config.getAuthUser(), config.getApiKey()));

        return builder.build();
    }
}
