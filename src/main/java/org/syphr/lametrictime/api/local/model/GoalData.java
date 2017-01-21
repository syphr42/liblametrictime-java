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

public class GoalData
{
    private Integer start;
    private Integer current;
    private Integer end;
    private String unit;

    public Integer getStart()
    {
        return start;
    }

    public void setStart(Integer start)
    {
        this.start = start;
    }

    public GoalData withStart(Integer start)
    {
        this.start = start;
        return this;
    }

    public Integer getCurrent()
    {
        return current;
    }

    public void setCurrent(Integer current)
    {
        this.current = current;
    }

    public GoalData withCurrent(Integer current)
    {
        this.current = current;
        return this;
    }

    public Integer getEnd()
    {
        return end;
    }

    public void setEnd(Integer end)
    {
        this.end = end;
    }

    public GoalData withEnd(Integer end)
    {
        this.end = end;
        return this;
    }

    public String getUnit()
    {
        return unit;
    }

    public void setUnit(String unit)
    {
        this.unit = unit;
    }

    public GoalData withUnit(String unit)
    {
        this.unit = unit;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("GoalData [start=");
        builder.append(start);
        builder.append(", current=");
        builder.append(current);
        builder.append(", end=");
        builder.append(end);
        builder.append(", unit=");
        builder.append(unit);
        builder.append("]");
        return builder.toString();
    }
}
