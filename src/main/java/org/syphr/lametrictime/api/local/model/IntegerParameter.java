/**
 * Copyright 2017-2018 Gregory Moyer and contributors.
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

public class IntegerParameter extends Parameter
{
    private Integer value;

    @Override
    public IntegerParameter withName(String name)
    {
        super.withName(name);
        return this;
    }

    @Override
    public IntegerParameter withRequired(Boolean required)
    {
        super.withRequired(required);
        return this;
    }

    public Integer getValue()
    {
        return value;
    }

    public void setValue(Integer value)
    {
        this.value = value;
    }

    public IntegerParameter withValue(Integer value)
    {
        setValue(value);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        builder.append("IntegerParameter [value=");
        builder.append(value);
        builder.append(", getName()=");
        builder.append(getName());
        builder.append(", getRequired()=");
        builder.append(getRequired());
        builder.append("]");
        return builder.toString();
    }
}
