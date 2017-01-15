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
package org.syphr.liblametrictime.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "active",
                     "address",
                     "available",
                     "encryption",
                     "essid",
                     "ip",
                     "mode",
                     "netmask",
                     "strength" })
public class Wifi
{
    @JsonProperty("active")
    private Boolean active;
    @JsonProperty("address")
    private String address;
    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("encryption")
    private String encryption;
    @JsonProperty("essid")
    private String essid;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("netmask")
    private String netmask;
    @JsonProperty("strength")
    private Integer strength;

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

    public Wifi withActive(Boolean active)
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

    public Wifi withAddress(String address)
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

    public Wifi withAvailable(Boolean available)
    {
        this.available = available;
        return this;
    }

    @JsonProperty("encryption")
    public String getEncryption()
    {
        return encryption;
    }

    @JsonProperty("encryption")
    public void setEncryption(String encryption)
    {
        this.encryption = encryption;
    }

    public Wifi withEncryption(String encryption)
    {
        this.encryption = encryption;
        return this;
    }

    @JsonProperty("essid")
    public String getEssid()
    {
        return essid;
    }

    @JsonProperty("essid")
    public void setEssid(String essid)
    {
        this.essid = essid;
    }

    public Wifi withEssid(String essid)
    {
        this.essid = essid;
        return this;
    }

    @JsonProperty("ip")
    public String getIp()
    {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip)
    {
        this.ip = ip;
    }

    public Wifi withIp(String ip)
    {
        this.ip = ip;
        return this;
    }

    @JsonProperty("mode")
    public String getMode()
    {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(String mode)
    {
        this.mode = mode;
    }

    public Wifi withMode(String mode)
    {
        this.mode = mode;
        return this;
    }

    @JsonProperty("netmask")
    public String getNetmask()
    {
        return netmask;
    }

    @JsonProperty("netmask")
    public void setNetmask(String netmask)
    {
        this.netmask = netmask;
    }

    public Wifi withNetmask(String netmask)
    {
        this.netmask = netmask;
        return this;
    }

    @JsonProperty("strength")
    public Integer getStrength()
    {
        return strength;
    }

    @JsonProperty("strength")
    public void setStrength(Integer strength)
    {
        this.strength = strength;
    }

    public Wifi withStrength(Integer strength)
    {
        this.strength = strength;
        return this;
    }
}
