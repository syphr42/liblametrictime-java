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
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.logging.LoggingFeature.Verbosity;
import org.syphr.lametrictime.api.common.impl.AbstractClient;
import org.syphr.lametrictime.api.local.Configuration;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.NotificationCreationException;
import org.syphr.lametrictime.api.local.NotificationNotFoundException;
import org.syphr.lametrictime.api.local.UpdateException;
import org.syphr.lametrictime.api.local.model.Api;
import org.syphr.lametrictime.api.local.model.Audio;
import org.syphr.lametrictime.api.local.model.Bluetooth;
import org.syphr.lametrictime.api.local.model.Device;
import org.syphr.lametrictime.api.local.model.Display;
import org.syphr.lametrictime.api.local.model.Failure;
import org.syphr.lametrictime.api.local.model.Notification;
import org.syphr.lametrictime.api.local.model.Wifi;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LaMetricTimeLocalImpl extends AbstractClient implements LaMetricTimeLocal
{
    private final Configuration config;

    private volatile Api api;

    public LaMetricTimeLocalImpl(Configuration config)
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
            JsonNode root = new ObjectMapper().readTree(response.readEntity(String.class));
            return root.get("success").get("id").asText();
        }
        catch (Exception e)
        {
            throw new NotificationCreationException("Invalid JSON returned from service", e);
        }
    }

    @Override
    public List<Notification> getNotifications()
    {
        return getClient().target(getApi().getEndpoints().getNotificationsUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          // @formatter:off
                          .get(new GenericType<List<Notification>>(){});
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
    public void updateDisplay(Display display) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getDisplayUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(display));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }
    }

    @Override
    public Audio getAudio()
    {
        return getClient().target(getApi().getEndpoints().getAudioUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Audio.class);
    }

    @Override
    public void updateAudio(Audio audio) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getAudioUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(audio));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }
    }

    @Override
    public Bluetooth getBluetooth()
    {
        return getClient().target(getApi().getEndpoints().getBluetoothUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Bluetooth.class);
    }

    @Override
    public void updateBluetooth(Bluetooth bluetooth) throws UpdateException
    {
        Response response = getClient().target(getApi().getEndpoints().getBluetoothUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(bluetooth));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new UpdateException(response.readEntity(Failure.class));
        }
    }

    @Override
    public Wifi getWifi()
    {
        return getClient().target(getApi().getEndpoints().getWifiUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Wifi.class);
    }

    @Override
    protected Client createClient()
    {
        ClientBuilder builder = ClientBuilder.newBuilder();

        // add custom ObjectMapper provider
        builder.register(JacksonObjectMapperProvider.class);
        builder.register(JacksonFeature.class);

        // deal with unverifiable cert
        if (config.isSecure())
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
                builder.sslContext(sslcontext)
                       .hostnameVerifier((host, session) -> host.equals(config.getHost()));
            }
            catch (KeyManagementException | NoSuchAlgorithmException e)
            {
                throw new RuntimeException("Failed to setup secure communication", e);
            }
        }

        // turn on logging if requested
        if (config.isLogging())
        {
            builder.register(new LoggingFeature(Logger.getLogger(LaMetricTimeLocalImpl.class.getName()),
                                                Level.parse(config.getLogLevel()),
                                                Verbosity.PAYLOAD_TEXT,
                                                config.getLogMax()));
        }

        // setup basic auth
        builder.register(HttpAuthenticationFeature.basic(config.getAuthUser(), config.getApiKey()));

        return builder.build();
    }
}
