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
package org.syphr.lametrictime.api;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.logging.Level;
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
import org.glassfish.jersey.logging.LoggingFeature;
import org.syphr.lametrictime.api.model.Api;
import org.syphr.lametrictime.api.model.Device;
import org.syphr.lametrictime.api.model.Endpoints;
import org.syphr.lametrictime.api.model.Notification;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LaMetricTimeImpl implements LaMetricTime
{
    private Configuration config;
    private volatile Client client;
    private Endpoints endpoints;

    public LaMetricTimeImpl(Configuration config)
    {
        this.config = config;
    }

    @Override
    public Endpoints getEndPoints()
    {
        return getClient().target(config.getBaseUri())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Api.class)
                          .getEndpoints();
    }

    @Override
    public Device getDevice()
    {
        if (endpoints == null)
        {
            endpoints = getEndPoints();
        }

        return getClient().target(endpoints.getDeviceUrl())
                          .request(MediaType.APPLICATION_JSON_TYPE)
                          .get(Device.class);
    }

    @Override
    public int createNotification(Notification notification)
    {
        if (endpoints == null)
        {
            endpoints = getEndPoints();
        }

        Response response = getClient().target(endpoints.getNotificationsUrl())
                                       .request(MediaType.APPLICATION_JSON_TYPE)
                                       .post(Entity.json(notification));

        if (!Status.Family.SUCCESSFUL.equals(response.getStatusInfo().getFamily()))
        {
            throw new RuntimeException("Failed to create notification ("
                                       + response.getStatus()
                                       + ")");
        }

        try
        {
            JsonNode root = new ObjectMapper().readTree(response.readEntity(String.class));
            return root.get("success").get("id").asInt();
        }
        catch (Exception e)
        {
            throw new RuntimeException("Invalid JSON returned from service", e);
        }
    }

    protected Client getClient()
    {
        if (client == null)
        {
            synchronized (this)
            {
                if (client == null)
                {
                    client = createClient();
                }
            }
        }

        return client;
    }

    protected Client createClient()
    {
        ClientBuilder builder = ClientBuilder.newBuilder();

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
            builder.register(new LoggingFeature(Logger.getLogger("LAMETRICTIME"),
                                                Level.INFO,
                                                null,
                                                null));
        }

        // setup basic auth
        builder.register(HttpAuthenticationFeature.basic(config.getAuthUser(), config.getApiKey()));

        return builder.build();
    }
}
