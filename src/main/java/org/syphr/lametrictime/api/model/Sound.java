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
@JsonPropertyOrder({ "category", "id", "repeat" })
public class Sound
{
    @JsonProperty("category")
    private SoundCategory category;
    @JsonProperty("id")
    private SoundId id;
    @JsonProperty("repeat")
    private Integer repeat;

    @JsonProperty("category")
    public SoundCategory getCategory()
    {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(SoundCategory category)
    {
        this.category = category;
    }

    public Sound withCategory(SoundCategory category)
    {
        this.category = category;
        return this;
    }

    @JsonProperty("id")
    public SoundId getId()
    {
        return id;
    }

    @JsonProperty("id")
    public void setId(SoundId id)
    {
        this.id = id;
    }

    public Sound withId(SoundId id)
    {
        this.id = id;
        return this;
    }

    @JsonProperty("repeat")
    public Integer getRepeat()
    {
        return repeat;
    }

    @JsonProperty("repeat")
    public void setRepeat(Integer repeat)
    {
        this.repeat = repeat;
    }

    public Sound withRepeat(Integer repeat)
    {
        this.repeat = repeat;
        return this;
    }
}
