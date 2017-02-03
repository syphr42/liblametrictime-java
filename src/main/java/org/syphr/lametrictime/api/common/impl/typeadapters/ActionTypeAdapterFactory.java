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

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.syphr.lametrictime.api.local.model.Action;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ActionTypeAdapterFactory extends CustomizedTypeAdapterFactory<Action>
{
    private static final String PROPERTY_ID = "id";
    private static final String PROPERTY_PARAMETERS = "params";

    public ActionTypeAdapterFactory()
    {
        super(Action.class);
    }

    @Override
    protected void beforeWrite(Action source, JsonElement toSerialize)
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

            paramsArr.forEach(paramElem ->
            {
                JsonObject paramObj = paramElem.getAsJsonObject();
                JsonPrimitive paramIdField = paramObj.getAsJsonPrimitive(PROPERTY_ID);
                String paramId = paramIdField.isJsonNull() ? "" : paramIdField.getAsString();
                paramObj.remove(PROPERTY_ID);
                actionObj.add(paramId, paramObj);
            });
        }
    }

    @Override
    protected void afterRead(JsonElement deserialized)
    {
        JsonObject actionObj = deserialized.getAsJsonObject();
        if (actionObj == null || actionObj.isJsonNull())
        {
            return;
        }

        // temporary list of field names
        List<String> fields = new ArrayList<>();

        // rewrite applications
        JsonArray paramsArr = new JsonArray();
        for (Entry<String, JsonElement> entry : actionObj.entrySet())
        {
            // skip any non-object fields
            if (!entry.getValue().isJsonObject())
            {
                continue;
            }

            String paramId = entry.getKey();
            fields.add(paramId); // to be removed later

            JsonObject paramObj = entry.getValue().getAsJsonObject();
            paramObj.addProperty(PROPERTY_ID, paramId);
            paramsArr.add(paramObj);
        }
        actionObj.add(PROPERTY_PARAMETERS, paramsArr);

        // remove all fields other than the list
        fields.forEach(field -> actionObj.remove(field));
    }
}
