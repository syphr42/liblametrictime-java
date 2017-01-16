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

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "icon", "text", "goalData", "chartData" })
public class Frame
{
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("text")
    private String text;
    @JsonProperty("goalData")
    private GoalData goalData;
    @JsonProperty("chartData")
    @JsonInclude(Include.NON_EMPTY)
    private List<Integer> chartData = new ArrayList<Integer>();

    @JsonProperty("icon")
    public String getIcon()
    {
        return icon;
    }

    @JsonProperty("icon")
    public void setIcon(String icon)
    {
        this.icon = icon;
    }

    public Frame withIcon(String icon)
    {
        this.icon = icon;
        return this;
    }

    @JsonProperty("text")
    public String getText()
    {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text)
    {
        this.text = text;
    }

    public Frame withText(String text)
    {
        this.text = text;
        return this;
    }

    @JsonProperty("goalData")
    public GoalData getGoalData()
    {
        return goalData;
    }

    @JsonProperty("goalData")
    public void setGoalData(GoalData goalData)
    {
        this.goalData = goalData;
    }

    public Frame withGoalData(GoalData goalData)
    {
        this.goalData = goalData;
        return this;
    }

    @JsonProperty("chartData")
    public List<Integer> getChartData()
    {
        return chartData;
    }

    @JsonProperty("chartData")
    public void setChartData(List<Integer> chartData)
    {
        this.chartData = chartData;
    }

    public Frame withChartData(List<Integer> chartData)
    {
        this.chartData = chartData;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Frame [icon=");
        builder.append(icon);
        builder.append(", text=");
        builder.append(text);
        builder.append(", goalData=");
        builder.append(goalData);
        builder.append(", chartData=");
        builder.append(chartData);
        builder.append("]");
        return builder.toString();
    }
}
