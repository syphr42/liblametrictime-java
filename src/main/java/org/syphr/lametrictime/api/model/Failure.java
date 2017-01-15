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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errors" })
public class Failure
{
    @JsonProperty("errors")
    private List<Error> errors = new ArrayList<Error>();

    @JsonProperty("errors")
    public List<Error> getErrors()
    {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(List<Error> errors)
    {
        this.errors = errors;
    }

    public Failure withErrors(List<Error> errors)
    {
        this.errors = errors;
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("Failure [errors=");
        builder.append(errors);
        builder.append("]");
        return builder.toString();
    }
}
