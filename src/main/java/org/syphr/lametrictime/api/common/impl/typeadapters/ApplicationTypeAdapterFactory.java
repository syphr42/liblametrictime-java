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

import java.util.Map.Entry;

import org.syphr.lametrictime.api.local.model.Application;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class ApplicationTypeAdapterFactory extends CustomizedTypeAdapterFactory<Application>
{
    private static final String PROPERTY_ID = "id";
    private static final String PROPERTY_WIDGETS = "widgets";
    private static final String PROPERTY_ACTIONS = "actions";

    public ApplicationTypeAdapterFactory()
    {
        super(Application.class);
    }

    @Override
    protected void beforeWrite(Application source, JsonElement toSerialize)
    {
        JsonObject appObj = toSerialize.getAsJsonObject();
        if (appObj == null || appObj.isJsonNull())
        {
            return;
        }

        // rewrite widgets
        JsonElement widgetsElem = appObj.get(PROPERTY_WIDGETS);
        if (widgetsElem != null && !widgetsElem.isJsonNull())
        {
            JsonArray widgetsArr = widgetsElem.getAsJsonArray();
            appObj.remove(PROPERTY_WIDGETS);

            JsonObject widgetsObj = new JsonObject();
            widgetsArr.forEach(widgetElem ->
            {
                JsonObject widgetObj = widgetElem.getAsJsonObject();
                JsonPrimitive widgetIdField = widgetObj.getAsJsonPrimitive(PROPERTY_ID);
                String widgetId = widgetIdField.isJsonNull() ? "" : widgetIdField.getAsString();
                widgetObj.remove(PROPERTY_ID);
                widgetsObj.add(widgetId, widgetObj);
            });
            appObj.add(PROPERTY_WIDGETS, widgetsObj);
        }

        // rewrite actions
        JsonElement actionsElem = appObj.get(PROPERTY_ACTIONS);
        if (actionsElem != null && !actionsElem.isJsonNull())
        {
            JsonArray actionsArr = actionsElem.getAsJsonArray();
            appObj.remove(PROPERTY_ACTIONS);

            JsonObject actionsObj = new JsonObject();
            actionsArr.forEach(actionElem ->
            {
                JsonObject actionObj = actionElem.getAsJsonObject();
                JsonPrimitive actionIdField = actionObj.getAsJsonPrimitive(PROPERTY_ID);
                String actionId = actionIdField.isJsonNull() ? "" : actionIdField.getAsString();
                actionObj.remove(PROPERTY_ID);
                actionsObj.add(actionId, actionObj);
            });
            appObj.add(PROPERTY_ACTIONS, actionsObj);
        }
    }

    @Override
    protected void afterRead(JsonElement deserialized)
    {
        JsonObject appObj = deserialized.getAsJsonObject();
        if (appObj == null || appObj.isJsonNull())
        {
            return;
        }

        // rewrite widgets
        JsonElement widgetsElem = appObj.get(PROPERTY_WIDGETS);
        if (widgetsElem != null && !widgetsElem.isJsonNull())
        {
            JsonObject widgetsObj = widgetsElem.getAsJsonObject();
            appObj.remove(PROPERTY_WIDGETS);

            JsonArray widgetsArr = new JsonArray();
            for (Entry<String, JsonElement> entry : widgetsObj.entrySet())
            {
                JsonElement widgetElem = entry.getValue();
                widgetElem.getAsJsonObject().addProperty(PROPERTY_ID, entry.getKey());
                widgetsArr.add(widgetElem);
            }
            appObj.add(PROPERTY_WIDGETS, widgetsArr);
        }

        // rewrite actions
        JsonElement actionsElem = appObj.get(PROPERTY_ACTIONS);
        if (actionsElem != null && !actionsElem.isJsonNull())
        {
            JsonObject actionsObj = actionsElem.getAsJsonObject();
            appObj.remove(PROPERTY_ACTIONS);

            JsonArray actionsArr = new JsonArray();
            for (Entry<String, JsonElement> entry : actionsObj.entrySet())
            {
                JsonElement actionElem = entry.getValue();
                actionElem.getAsJsonObject().addProperty(PROPERTY_ID, entry.getKey());
                actionsArr.add(actionElem);
            }
            appObj.add(PROPERTY_ACTIONS, actionsArr);
        }
    }
}
