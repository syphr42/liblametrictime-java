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

public class Sound
{
    private SoundCategory category;
    private SoundId id;
    private Integer repeat;

    public SoundCategory getCategory()
    {
        return category;
    }

    public void setCategory(SoundCategory category)
    {
        this.category = category;
    }

    public Sound withCategory(SoundCategory category)
    {
        this.category = category;
        return this;
    }

    public SoundId getId()
    {
        return id;
    }

    public void setId(SoundId id)
    {
        this.id = id;
    }

    public Sound withId(SoundId id)
    {
        this.id = id;
        return this;
    }

    public void setCategoryAndId(SoundId id)
    {
        this.category = id.getCategory();
        this.id = id;
    }

    public Sound withCategoryAndId(SoundId id)
    {
        this.category = id.getCategory();
        this.id = id;
        return this;
    }

    public Integer getRepeat()
    {
        return repeat;
    }

    public void setRepeat(Integer repeat)
    {
        this.repeat = repeat;
    }

    public Sound withRepeat(Integer repeat)
    {
        this.repeat = repeat;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Sound [category=");
        builder.append(category);
        builder.append(", id=");
        builder.append(id);
        builder.append(", repeat=");
        builder.append(repeat);
        builder.append("]");
        return builder.toString();
    }
}
