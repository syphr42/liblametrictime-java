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
@JsonPropertyOrder({ "priority", "lifetime", "icon_type", "model" })
public class Notification
{
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("lifetime")
    private Integer lifetime;
    @JsonProperty("icon_type")
    private IconType iconType;
    @JsonProperty("model")
    private NotificationModel model;

    @JsonProperty("priority")
    public Priority getPriority()
    {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Priority priority)
    {
        this.priority = priority;
    }

    public Notification withPriority(Priority priority)
    {
        this.priority = priority;
        return this;
    }

    @JsonProperty("lifetime")
    public Integer getLifetime()
    {
        return lifetime;
    }

    @JsonProperty("lifetime")
    public void setLifetime(Integer lifetime)
    {
        this.lifetime = lifetime;
    }

    public Notification withLifetime(Integer lifetime)
    {
        this.lifetime = lifetime;
        return this;
    }

    @JsonProperty("icon_type")
    public IconType getIconType()
    {
        return iconType;
    }

    @JsonProperty("icon_type")
    public void setIconType(IconType iconType)
    {
        this.iconType = iconType;
    }

    public Notification withIconType(IconType iconType)
    {
        this.iconType = iconType;
        return this;
    }

    @JsonProperty("model")
    public NotificationModel getModel()
    {
        return model;
    }

    @JsonProperty("model")
    public void setModel(NotificationModel model)
    {
        this.model = model;
    }

    public Notification withModel(NotificationModel model)
    {
        this.model = model;
        return this;
    }
}
