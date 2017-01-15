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
@JsonPropertyOrder({ "start", "current", "end", "unit" })
public class GoalData
{
    @JsonProperty("start")
    private Integer start;
    @JsonProperty("current")
    private Integer current;
    @JsonProperty("end")
    private Integer end;
    @JsonProperty("unit")
    private String unit;

    @JsonProperty("start")
    public Integer getStart()
    {
        return start;
    }

    @JsonProperty("start")
    public void setStart(Integer start)
    {
        this.start = start;
    }

    public GoalData withStart(Integer start)
    {
        this.start = start;
        return this;
    }

    @JsonProperty("current")
    public Integer getCurrent()
    {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Integer current)
    {
        this.current = current;
    }

    public GoalData withCurrent(Integer current)
    {
        this.current = current;
        return this;
    }

    @JsonProperty("end")
    public Integer getEnd()
    {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(Integer end)
    {
        this.end = end;
    }

    public GoalData withEnd(Integer end)
    {
        this.end = end;
        return this;
    }

    @JsonProperty("unit")
    public String getUnit()
    {
        return unit;
    }

    @JsonProperty("unit")
    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public GoalData withUnit(String unit)
    {
        this.unit = unit;
        return this;
    }
}
