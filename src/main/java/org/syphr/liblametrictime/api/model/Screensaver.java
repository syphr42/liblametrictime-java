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
@JsonPropertyOrder({ "enabled", "modes", "widget" })
public class Screensaver
{
    @JsonProperty("enabled")
    private Boolean enabled;
    @JsonProperty("modes")
    private Modes modes;
    @JsonProperty("widget")
    private String widget;

    @JsonProperty("enabled")
    public Boolean getEnabled()
    {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Boolean enabled)
    {
        this.enabled = enabled;
    }

    public Screensaver withEnabled(Boolean enabled)
    {
        this.enabled = enabled;
        return this;
    }

    @JsonProperty("modes")
    public Modes getModes()
    {
        return modes;
    }

    @JsonProperty("modes")
    public void setModes(Modes modes)
    {
        this.modes = modes;
    }

    public Screensaver withModes(Modes modes)
    {
        this.modes = modes;
        return this;
    }

    @JsonProperty("widget")
    public String getWidget()
    {
        return widget;
    }

    @JsonProperty("widget")
    public void setWidget(String widget)
    {
        this.widget = widget;
    }

    public Screensaver withWidget(String widget)
    {
        this.widget = widget;
        return this;
    }
}
