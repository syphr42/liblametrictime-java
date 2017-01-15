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
@JsonPropertyOrder({ "audio",
                     "bluetooth",
                     "display",
                     "id",
                     "mode",
                     "model",
                     "name",
                     "os_version",
                     "serial_number",
                     "wifi" })
public class Device
{
    @JsonProperty("audio")
    private Audio audio;
    @JsonProperty("bluetooth")
    private Bluetooth bluetooth;
    @JsonProperty("display")
    private Display display;
    @JsonProperty("id")
    private String id;
    @JsonProperty("mode")
    private String mode;
    @JsonProperty("model")
    private String model;
    @JsonProperty("name")
    private String name;
    @JsonProperty("os_version")
    private String osVersion;
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("wifi")
    private Wifi wifi;

    @JsonProperty("audio")
    public Audio getAudio()
    {
        return audio;
    }

    @JsonProperty("audio")
    public void setAudio(Audio audio)
    {
        this.audio = audio;
    }

    public Device withAudio(Audio audio)
    {
        this.audio = audio;
        return this;
    }

    @JsonProperty("bluetooth")
    public Bluetooth getBluetooth()
    {
        return bluetooth;
    }

    @JsonProperty("bluetooth")
    public void setBluetooth(Bluetooth bluetooth)
    {
        this.bluetooth = bluetooth;
    }

    public Device withBluetooth(Bluetooth bluetooth)
    {
        this.bluetooth = bluetooth;
        return this;
    }

    @JsonProperty("display")
    public Display getDisplay()
    {
        return display;
    }

    @JsonProperty("display")
    public void setDisplay(Display display)
    {
        this.display = display;
    }

    public Device withDisplay(Display display)
    {
        this.display = display;
        return this;
    }

    @JsonProperty("id")
    public String getId()
    {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id)
    {
        this.id = id;
    }

    public Device withId(String id)
    {
        this.id = id;
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

    public Device withMode(String mode)
    {
        this.mode = mode;
        return this;
    }

    @JsonProperty("model")
    public String getModel()
    {
        return model;
    }

    @JsonProperty("model")
    public void setModel(String model)
    {
        this.model = model;
    }

    public Device withModel(String model)
    {
        this.model = model;
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

    public Device withName(String name)
    {
        this.name = name;
        return this;
    }

    @JsonProperty("os_version")
    public String getOsVersion()
    {
        return osVersion;
    }

    @JsonProperty("os_version")
    public void setOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
    }

    public Device withOsVersion(String osVersion)
    {
        this.osVersion = osVersion;
        return this;
    }

    @JsonProperty("serial_number")
    public String getSerialNumber()
    {
        return serialNumber;
    }

    @JsonProperty("serial_number")
    public void setSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
    }

    public Device withSerialNumber(String serialNumber)
    {
        this.serialNumber = serialNumber;
        return this;
    }

    @JsonProperty("wifi")
    public Wifi getWifi()
    {
        return wifi;
    }

    @JsonProperty("wifi")
    public void setWifi(Wifi wifi)
    {
        this.wifi = wifi;
    }

    public Device withWifi(Wifi wifi)
    {
        this.wifi = wifi;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Device [audio=");
        builder.append(audio);
        builder.append(", bluetooth=");
        builder.append(bluetooth);
        builder.append(", display=");
        builder.append(display);
        builder.append(", id=");
        builder.append(id);
        builder.append(", mode=");
        builder.append(mode);
        builder.append(", model=");
        builder.append(model);
        builder.append(", name=");
        builder.append(name);
        builder.append(", osVersion=");
        builder.append(osVersion);
        builder.append(", serialNumber=");
        builder.append(serialNumber);
        builder.append(", wifi=");
        builder.append(wifi);
        builder.append("]");
        return builder.toString();
    }
}
