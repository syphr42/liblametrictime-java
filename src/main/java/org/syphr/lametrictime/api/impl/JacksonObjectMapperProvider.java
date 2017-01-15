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
package org.syphr.lametrictime.api.impl;

import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Provider
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper>
{
    private final ObjectMapper defaultObjectMapper;

    public JacksonObjectMapperProvider()
    {
        defaultObjectMapper = createDefaultMapper();
    }

    @Override
    public ObjectMapper getContext(Class<?> type)
    {
        return defaultObjectMapper;
    }

    private static ObjectMapper createDefaultMapper()
    {
        final ObjectMapper mapper = new ObjectMapper();

        // add support for Java 8 Time API
        mapper.registerModule(new JavaTimeModule());

        return mapper;
    }
}
