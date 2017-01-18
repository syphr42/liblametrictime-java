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
@JsonPropertyOrder({ "id", "title", "code", "type", "category", "url", "thumb" })
public class Icon
{
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("title")
    private String title;
    @JsonProperty("code")
    private String code;
    @JsonProperty("type")
    private IconType type;
    @JsonProperty("category")
    private String category;
    @JsonProperty("url")
    private String url;
    @JsonProperty("thumb")
    private Thumb thumb;

    @JsonProperty("id")
    public Integer getId()
    {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id)
    {
        this.id = id;
    }

    public Icon withId(Integer id)
    {
        this.id = id;
        return this;
    }

    @JsonProperty("title")
    public String getTitle()
    {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title)
    {
        this.title = title;
    }

    public Icon withTitle(String title)
    {
        this.title = title;
        return this;
    }

    @JsonProperty("code")
    public String getCode()
    {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code)
    {
        this.code = code;
    }

    public Icon withCode(String code)
    {
        this.code = code;
        return this;
    }

    @JsonProperty("type")
    public IconType getType()
    {
        return type;
    }

    @JsonProperty("type")
    public void setType(IconType type)
    {
        this.type = type;
    }

    public Icon withType(IconType type)
    {
        this.type = type;
        return this;
    }

    @JsonProperty("category")
    public String getCategory()
    {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(String category)
    {
        this.category = category;
    }

    public Icon withCategory(String category)
    {
        this.category = category;
        return this;
    }

    @JsonProperty("url")
    public String getUrl()
    {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url)
    {
        this.url = url;
    }

    public Icon withUrl(String url)
    {
        this.url = url;
        return this;
    }

    @JsonProperty("thumb")
    public Thumb getThumb()
    {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(Thumb thumb)
    {
        this.thumb = thumb;
    }

    public Icon withThumb(Thumb thumb)
    {
        this.thumb = thumb;
        return this;
    }
}
