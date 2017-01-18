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
package org.syphr.lametrictime.api.cloud.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "meta", "data" })
public class Icons
{
    @JsonProperty("meta")
    private IconsMetadata meta;
    @JsonProperty("data")
    private List<Icon> data = new ArrayList<Icon>();

    @JsonProperty("meta")
    public IconsMetadata getMeta()
    {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(IconsMetadata meta)
    {
        this.meta = meta;
    }

    public Icons withMeta(IconsMetadata meta)
    {
        this.meta = meta;
        return this;
    }

    @JsonProperty("data")
    public List<Icon> getData()
    {
        return data;
    }

    @JsonProperty("data")
    public void setData(List<Icon> data)
    {
        this.data = data;
    }

    public Icons withData(List<Icon> data)
    {
        this.data = data;
        return this;
    }
}
