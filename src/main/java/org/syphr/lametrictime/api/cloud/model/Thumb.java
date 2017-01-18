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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "original", "small", "large", "xlarge" })
public class Thumb
{
    @JsonProperty("original")
    private String original;
    @JsonProperty("small")
    private String small;
    @JsonProperty("large")
    private String large;
    @JsonProperty("xlarge")
    private String xlarge;

    @JsonProperty("original")
    public String getOriginal()
    {
        return original;
    }

    @JsonProperty("original")
    public void setOriginal(String original)
    {
        this.original = original;
    }

    public Thumb withOriginal(String original)
    {
        this.original = original;
        return this;
    }

    @JsonProperty("small")
    public String getSmall()
    {
        return small;
    }

    @JsonProperty("small")
    public void setSmall(String small)
    {
        this.small = small;
    }

    public Thumb withSmall(String small)
    {
        this.small = small;
        return this;
    }

    @JsonProperty("large")
    public String getLarge()
    {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(String large)
    {
        this.large = large;
    }

    public Thumb withLarge(String large)
    {
        this.large = large;
        return this;
    }

    @JsonProperty("xlarge")
    public String getXlarge()
    {
        return xlarge;
    }

    @JsonProperty("xlarge")
    public void setXlarge(String xlarge)
    {
        this.xlarge = xlarge;
    }

    public Thumb withXlarge(String xlarge)
    {
        this.xlarge = xlarge;
        return this;
    }
}
