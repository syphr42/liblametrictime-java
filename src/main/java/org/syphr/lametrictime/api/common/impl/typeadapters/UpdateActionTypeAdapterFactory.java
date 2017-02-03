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
package org.syphr.lametrictime.api.common.impl.typeadapters;

import org.syphr.lametrictime.api.local.model.UpdateAction;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class UpdateActionTypeAdapterFactory extends CustomizedTypeAdapterFactory<UpdateAction>
{
    private static final String PROPERTY_PARAMETERS = "params";
    private static final String PROPERTY_ID = "id";
    private static final String PROPERTY_VALUE = "value";

    public UpdateActionTypeAdapterFactory()
    {
        super(UpdateAction.class);
    }

    @Override
    protected void beforeWrite(UpdateAction source, JsonElement toSerialize)
    {
        JsonObject actionObj = toSerialize.getAsJsonObject();
        if (actionObj == null || actionObj.isJsonNull())
        {
            return;
        }

        // rewrite parameters
        JsonElement paramsElem = actionObj.get(PROPERTY_PARAMETERS);
        if (paramsElem != null && !paramsElem.isJsonNull())
        {
            JsonArray paramsArr = paramsElem.getAsJsonArray();
            actionObj.remove(PROPERTY_PARAMETERS);

            JsonObject paramsObj = new JsonObject();
            paramsArr.forEach(paramElem ->
            {
                JsonObject paramObj = paramElem.getAsJsonObject();
                JsonPrimitive paramIdField = paramObj.getAsJsonPrimitive(PROPERTY_ID);
                if (paramIdField.isJsonNull())
                {
                    return;
                }

                paramsObj.add(paramIdField.getAsString(),
                              paramObj.getAsJsonPrimitive(PROPERTY_VALUE));
            });
            actionObj.add(PROPERTY_PARAMETERS, paramsObj);
        }
    }

    @Override
    protected void afterRead(JsonElement deserialized)
    {
        throw new UnsupportedOperationException(UpdateAction.class.getName()
                                                + " cannot be derialized");
    }
}
