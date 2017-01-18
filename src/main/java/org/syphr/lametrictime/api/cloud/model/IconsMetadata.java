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
@JsonPropertyOrder({ "total_icon_count", "page", "page_size", "page_count" })
public class IconsMetadata
{
    @JsonProperty("total_icon_count")
    private Integer totalIconCount;
    @JsonProperty("page")
    private Integer page;
    @JsonProperty("page_size")
    private Integer pageSize;
    @JsonProperty("page_count")
    private Integer pageCount;

    @JsonProperty("total_icon_count")
    public Integer getTotalIconCount()
    {
        return totalIconCount;
    }

    @JsonProperty("total_icon_count")
    public void setTotalIconCount(Integer totalIconCount)
    {
        this.totalIconCount = totalIconCount;
    }

    public IconsMetadata withTotalIconCount(Integer totalIconCount)
    {
        this.totalIconCount = totalIconCount;
        return this;
    }

    @JsonProperty("page")
    public Integer getPage()
    {
        return page;
    }

    @JsonProperty("page")
    public void setPage(Integer page)
    {
        this.page = page;
    }

    public IconsMetadata withPage(Integer page)
    {
        this.page = page;
        return this;
    }

    @JsonProperty("page_size")
    public Integer getPageSize()
    {
        return pageSize;
    }

    @JsonProperty("page_size")
    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public IconsMetadata withPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
        return this;
    }

    @JsonProperty("page_count")
    public Integer getPageCount()
    {
        return pageCount;
    }

    @JsonProperty("page_count")
    public void setPageCount(Integer pageCount)
    {
        this.pageCount = pageCount;
    }

    public IconsMetadata withPageCount(Integer pageCount)
    {
        this.pageCount = pageCount;
        return this;
    }
}
