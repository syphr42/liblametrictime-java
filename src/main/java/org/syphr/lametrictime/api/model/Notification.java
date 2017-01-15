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

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id",
                     "type",
                     "created",
                     "expiration_date",
                     "priority",
                     "icon_type",
                     "lifetime",
                     "model" })
public class Notification
{
    @JsonProperty("id")
    private String id;
    @JsonProperty("type")
    private String type;
    @JsonProperty("created")
    private LocalDateTime created;
    @JsonProperty("expiration_date")
    private LocalDateTime expirationDate;
    @JsonProperty("priority")
    private Priority priority;
    @JsonProperty("icon_type")
    private IconType iconType;
    @JsonProperty("lifetime")
    private Integer lifetime;
    @JsonProperty("model")
    private NotificationModel model;

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

    public Notification withId(String id)
    {
        this.id = id;
        return this;
    }

    @JsonProperty("type")
    public String getType()
    {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type)
    {
        this.type = type;
    }

    public Notification withType(String type)
    {
        this.type = type;
        return this;
    }

    @JsonProperty("created")
    public LocalDateTime getCreated()
    {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(LocalDateTime created)
    {
        this.created = created;
    }

    public Notification withCreated(LocalDateTime created)
    {
        this.created = created;
        return this;
    }

    @JsonProperty("expiration_date")
    public LocalDateTime getExpirationDate()
    {
        return expirationDate;
    }

    @JsonProperty("expiration_date")
    public void setExpirationDate(LocalDateTime expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    public Notification withExpirationDate(LocalDateTime expirationDate)
    {
        this.expirationDate = expirationDate;
        return this;
    }

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

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Notification [id=");
        builder.append(id);
        builder.append(", type=");
        builder.append(type);
        builder.append(", created=");
        builder.append(created);
        builder.append(", expirationDate=");
        builder.append(expirationDate);
        builder.append(", priority=");
        builder.append(priority);
        builder.append(", iconType=");
        builder.append(iconType);
        builder.append(", lifetime=");
        builder.append(lifetime);
        builder.append(", model=");
        builder.append(model);
        builder.append("]");
        return builder.toString();
    }
}
