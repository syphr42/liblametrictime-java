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
@JsonPropertyOrder({ "active",
                     "address",
                     "mac",
                     "available",
                     "encryption",
                     "essid",
                     "ssid",
                     "ip",
                     "ipv4",
                     "mode",
                     "netmask",
                     "strength",
                     "signal_strength" })
public class Wifi
{
    @JsonProperty("active")
    private Boolean active;

    // API sometimes calls this field 'address' and other times calls it 'mac' :(
    @JsonProperty("address")
    private String address;

    @JsonProperty("available")
    private Boolean available;
    @JsonProperty("encryption")
    private WifiEncryption encryption;

    // API sometimes calls this field 'essid' and other times calls it 'ssid' :(
    @JsonProperty("essid")
    private String essid;

    // API sometimes calls this field 'ip' and other times calls it 'ipv4' :(
    @JsonProperty("ip")
    private String ip;

    @JsonProperty("mode")
    private IpMode mode;
    @JsonProperty("netmask")
    private String netmask;

    // API sometimes calls this field 'strength' and other times calls it 'signal_strength' :(
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

    @JsonProperty("mac")
    public String getMac()
    {
        return address;
    }

    @JsonProperty("mac")
    public void setMac(String mac)
    {
        this.address = mac;
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
    public WifiEncryption getEncryption()
    {
        return encryption;
    }

    @JsonProperty("encryption")
    public void setEncryption(WifiEncryption encryption)
    {
        this.encryption = encryption;
    }

    public Wifi withEncryption(WifiEncryption encryption)
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

    @JsonProperty("ssid")
    public String getSsid()
    {
        return essid;
    }

    @JsonProperty("ssid")
    public void setSsid(String ssid)
    {
        this.essid = ssid;
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

    @JsonProperty("ipv4")
    public String getIpv4()
    {
        return ip;
    }

    @JsonProperty("ipv4")
    public void setIpv4(String ipv4)
    {
        this.ip = ipv4;
    }

    @JsonProperty("mode")
    public IpMode getMode()
    {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(IpMode mode)
    {
        this.mode = mode;
    }

    public Wifi withMode(IpMode mode)
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

    @JsonProperty("signal_strength")
    public Integer getSignalStrength()
    {
        return strength;
    }

    @JsonProperty("signal_strength")
    public void setSignalStrength(Integer signalStrength)
    {
        this.strength = signalStrength;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Wifi [active=");
        builder.append(active);
        builder.append(", address=");
        builder.append(address);
        builder.append(", available=");
        builder.append(available);
        builder.append(", encryption=");
        builder.append(encryption);
        builder.append(", essid=");
        builder.append(essid);
        builder.append(", ip=");
        builder.append(ip);
        builder.append(", mode=");
        builder.append(mode);
        builder.append(", netmask=");
        builder.append(netmask);
        builder.append(", strength=");
        builder.append(strength);
        builder.append("]");
        return builder.toString();
    }
}
