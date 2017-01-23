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
package org.syphr.lametrictime.api.common.impl;

import org.syphr.lametrictime.api.common.impl.typeadapters.JSR310TypeAdapters;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonGenerator
{
    public static Gson create()
    {
        return create(false);
    }

    public static Gson create(boolean prettyPrint)
    {
        GsonBuilder builder = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        JSR310TypeAdapters.registerJSR310TypeAdapters(builder);

        if (prettyPrint)
        {
            builder.setPrettyPrinting();
        }

        return builder.create();
    }

    // @formatter:off
    private GsonGenerator() {}
    // @formatter:on
}