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
package org.syphr.lametrictime.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "active", "address", "available", "discoverable", "name", "pairable" })
public class Bluetooth
{
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("address")
    private String address;
    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("discoverable")
    private Boolean discoverable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("pairable")
    private Boolean pairable;

    @JsonProperty("active")
    public Boolean getActive()
    {
        return active;
    }

    @JsonProperty("active")
    public void setActive(Boolean active)
    {
        this.active = active;
    }

    public Bluetooth withActive(Boolean active)
    {
        this.active = active;
        return this;
    }

    @JsonProperty("address")
    public String getAddress()
    {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address)
    {
        this.address = address;
    }

    public Bluetooth withAddress(String address)
    {
        this.address = address;
        return this;
    }

    @JsonProperty("available")
    public Boolean getAvailable()
    {
        return available;
    }

    @JsonProperty("available")
    public void setAvailable(Boolean available)
    {
        this.available = available;
    }

    public Bluetooth withAvailable(Boolean available)
    {
        this.available = available;
        return this;
    }

    @JsonProperty("discoverable")
    public Boolean getDiscoverable()
    {
        return discoverable;
    }

    @JsonProperty("discoverable")
    public void setDiscoverable(Boolean discoverable)
    {
        this.discoverable = discoverable;
    }

    public Bluetooth withDiscoverable(Boolean discoverable)
    {
        this.discoverable = discoverable;
        return this;
    }

    @JsonProperty("name")
    public String getName()
    {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name)
    {
        this.name = name;
    }

    public Bluetooth withName(String name)
    {
        this.name = name;
        return this;
    }

    @JsonProperty("pairable")
    public Boolean getPairable()
    {
        return pairable;
    }

    @JsonProperty("pairable")
    public void setPairable(Boolean pairable)
    {
        this.pairable = pairable;
    }

    public Bluetooth withPairable(Boolean pairable)
    {
        this.pairable = pairable;
        return this;
    }
}
