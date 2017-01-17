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
package org.syphr.lametrictime.api.local.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "api_version", "endpoints" })
public class Api
{
    @JsonProperty("api_version")
    private String apiVersion;
    @JsonProperty("endpoints")
    private Endpoints endpoints;

    @JsonProperty("api_version")
    public String getApiVersion()
    {
        return apiVersion;
    }

    @JsonProperty("api_version")
    public void setApiVersion(String apiVersion)
    {
        this.apiVersion = apiVersion;
    }

    public Api withApiVersion(String apiVersion)
    {
        this.apiVersion = apiVersion;
        return this;
    }

    @JsonProperty("endpoints")
    public Endpoints getEndpoints()
    {
        return endpoints;
    }

    @JsonProperty("endpoints")
    public void setEndpoints(Endpoints endpoints)
    {
        this.endpoints = endpoints;
    }

    public Api withEndpoints(Endpoints endpoints)
    {
        this.endpoints = endpoints;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Api [apiVersion=");
        builder.append(apiVersion);
        builder.append(", endpoints=");
        builder.append(endpoints);
        builder.append("]");
        return builder.toString();
    }
}