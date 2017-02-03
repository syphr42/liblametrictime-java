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

import org.syphr.lametrictime.api.local.model.Applications;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ApplicationsTypeAdapterFactory extends CustomizedTypeAdapterFactory<Applications>
{
    private static final String PROPERTY_LIST = "list";
    private static final String PROPERTY_ID = "id";

    public ApplicationsTypeAdapterFactory()
    {
        super(Applications.class);
    }

    @Override
    protected void beforeWrite(Applications source, JsonElement toSerialize)
    {
        JsonObject appsObj = toSerialize.getAsJsonObject();
        if (appsObj == null || appsObj.isJsonNull())
        {
            return;
        }

        // rewrite applications
        JsonElement listElem = appsObj.get(PROPERTY_LIST);
        if (listElem != null && !listElem.isJsonNull())
        {
            JsonArray listArr = listElem.getAsJsonArray();
            appsObj.remove(PROPERTY_LIST);

            listArr.forEach(appElem ->
            {
                JsonObject appObj = appElem.getAsJsonObject();
                JsonPrimitive appIdField = appObj.getAsJsonPrimitive(PROPERTY_ID);
                String appId = appIdField.isJsonNull() ? "" : appIdField.getAsString();
                appObj.remove(PROPERTY_ID);
                appsObj.add(appId, appObj);
            });
        }
    }

    @Override
    protected void afterRead(JsonElement deserialized)
    {
        JsonObject appsObj = deserialized.getAsJsonObject();
        if (appsObj == null || appsObj.isJsonNull())
        {
            return;
        }

        // temporary list of field names
        List<String> fields = new ArrayList<>();

        // rewrite applications
        JsonArray listArr = new JsonArray();
        for (Entry<String, JsonElement> entry : appsObj.entrySet())
        {
            String appId = entry.getKey();
            fields.add(appId); // to be removed later

            JsonObject appObj = entry.getValue().getAsJsonObject();
            appObj.addProperty(PROPERTY_ID, appId);
            listArr.add(appObj);
        }
        appsObj.add(PROPERTY_LIST, listArr);

        // remove all fields other than the list
        fields.forEach(field -> appsObj.remove(field));
    }
}
