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

import java.net.URI;
import java.net.URISyntaxException;

public class Configuration
{
    private String host;
    private String apiKey;

    private boolean secure = true;

    private String insecureScheme = "http";
    private int insecurePort = 8080;

    private String secureScheme = "https";
    private int securePort = 4343;

    private String basePath = "/api/v2";

    private String authUser = "dev";

    private boolean logging = false;
    private String logLevel = "INFO";
    private int logMax = 104857600; // 100kb

    public Configuration()
    {
        super();
    }

    public Configuration(String host, String apiKey)
    {
        this(host, apiKey, true);
    }

    public Configuration(String host, String apiKey, boolean secure)
    {
        this.host = host;
        this.apiKey = apiKey;
        this.secure = secure;
    }

    public String getHost()
    {
        return host;
    }

    public void setHost(String host)
    {
        this.host = host;
    }

    public String getApiKey()
    {
        return apiKey;
    }

    public void setApiKey(String apiKey)
    {
        this.apiKey = apiKey;
    }

    public boolean isSecure()
    {
        return secure;
    }

    public void setSecure(boolean secure)
    {
        this.secure = secure;
    }

    public String getInsecureScheme()
    {
        return insecureScheme;
    }

    public void setInsecureScheme(String insecureScheme)
    {
        this.insecureScheme = insecureScheme;
    }

    public int getInsecurePort()
    {
        return insecurePort;
    }

    public void setInsecurePort(int insecurePort)
    {
        this.insecurePort = insecurePort;
    }

    public String getSecureScheme()
    {
        return secureScheme;
    }

    public void setSecureScheme(String secureScheme)
    {
        this.secureScheme = secureScheme;
    }

    public int getSecurePort()
    {
        return securePort;
    }

    public void setSecurePort(int securePort)
    {
        this.securePort = securePort;
    }

    public String getBasePath()
    {
        return basePath;
    }

    public void setBasePath(String basePath)
    {
        this.basePath = basePath;
    }

    public String getAuthUser()
    {
        return authUser;
    }

    public void setAuthUser(String authUser)
    {
        this.authUser = authUser;
    }

    public boolean isLogging()
    {
        return logging;
    }

    public void setLogging(boolean logging)
    {
        this.logging = logging;
    }

    public String getLogLevel()
    {
        return logLevel;
    }

    public void setLogLevel(String logLevel)
    {
        this.logLevel = logLevel;
    }

    public int getLogMax()
    {
        return logMax;
    }

    public void setLogMax(int logMax)
    {
        this.logMax = logMax;
    }

    public URI getBaseUri()
    {
        String scheme = secure ? secureScheme : insecureScheme;
        int port = secure ? securePort : insecurePort;
        try
        {
            return new URI(scheme, null, host, port, basePath, null, null);
        }
        catch (URISyntaxException e)
        {
            throw new RuntimeException("Invalid configuration", e);
        }
    }
}
