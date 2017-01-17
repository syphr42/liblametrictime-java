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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "cycles", "frames", "sound" })
public class NotificationModel
{
    @JsonProperty("cycles")
    private Integer cycles;
    @JsonProperty("frames")
    private List<Frame> frames = new ArrayList<Frame>();
    @JsonProperty("sound")
    private Sound sound;

    @JsonProperty("cycles")
    public Integer getCycles()
    {
        return cycles;
    }

    @JsonProperty("cycles")
    public void setCycles(Integer cycles)
    {
        this.cycles = cycles;
    }

    public NotificationModel withCycles(Integer cycles)
    {
        this.cycles = cycles;
        return this;
    }

    @JsonProperty("frames")
    public List<Frame> getFrames()
    {
        return frames;
    }

    @JsonProperty("frames")
    public void setFrames(List<Frame> frames)
    {
        this.frames = frames;
    }

    public NotificationModel withFrames(List<Frame> frames)
    {
        this.frames = frames;
        return this;
    }

    @JsonProperty("sound")
    public Sound getSound()
    {
        return sound;
    }

    @JsonProperty("sound")
    public void setSound(Sound sound)
    {
        this.sound = sound;
    }

    public NotificationModel withSound(Sound sound)
    {
        this.sound = sound;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("NotificationModel [cycles=");
        builder.append(cycles);
        builder.append(", frames=");
        builder.append(frames);
        builder.append(", sound=");
        builder.append(sound);
        builder.append("]");
        return builder.toString();
    }
}
