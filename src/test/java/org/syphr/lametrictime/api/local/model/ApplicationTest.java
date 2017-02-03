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
package org.syphr.lametrictime.api.local.model;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.syphr.lametrictime.api.common.impl.GsonGenerator;
import org.syphr.lametrictime.api.test.AbstractTest;

import com.google.gson.Gson;

public class ApplicationTest extends AbstractTest
{
    private static Gson gson;

    @BeforeClass
    public static void setUpBeforeClass()
    {
        gson = GsonGenerator.create(true);
    }

    @Test
    public void testSerializeAllFields() throws Exception
    {
        Application app = new Application().withPackageName("com.lametric.radio")
                                           .withVendor("LaMetric")
                                           .withVersion("1.0.10")
                                           .withVersionCode("22")
                                           .withWidgets(Arrays.asList(new Widget().withId("589ed1b3fcdaa5180bf4848e55ba8061")))
                                           .withActions(Arrays.asList(new Action().withId("radio.next"),
                                                                      new Action().withId("radio.play"),
                                                                      new Action().withId("radio.prev"),
                                                                      new Action().withId("radio.stop")));
        assertEquals(readJson("application-all.json"), gson.toJson(app));
    }

    @Test
    public void testSerializeNullLists() throws Exception
    {
        Application app = new Application().withPackageName("com.lametric.radio")
                                           .withVendor("LaMetric")
                                           .withVersion("1.0.10")
                                           .withVersionCode("22");
        assertEquals(readJson("application-null-lists.json"), gson.toJson(app));
    }

    @Test
    public void testDeserializeAllFields() throws Exception
    {
        try (FileReader reader = new FileReader(getTestDataFile("application-all.json")))
        {
            Application app = gson.fromJson(reader, Application.class);
            assertEquals("com.lametric.radio", app.getPackageName());
            assertEquals("LaMetric", app.getVendor());
            assertEquals("1.0.10", app.getVersion());
            assertEquals("22", app.getVersionCode());

            List<Widget> widgets = app.getWidgets();
            assertNotNull(widgets);
            assertEquals(1, widgets.size());
            assertEquals("589ed1b3fcdaa5180bf4848e55ba8061", widgets.get(0).getId());

            List<Action> actions = app.getActions();
            assertNotNull(actions);
            assertEquals(4, actions.size());
            assertEquals("radio.next", actions.get(0).getId());
            assertEquals("radio.play", actions.get(1).getId());
            assertEquals("radio.prev", actions.get(2).getId());
            assertEquals("radio.stop", actions.get(3).getId());
        }
    }

    @Test
    public void testDeserializeNullLists() throws Exception
    {
        try (FileReader reader = new FileReader(getTestDataFile("application-null-lists.json")))
        {
            Application app = gson.fromJson(reader, Application.class);
            assertEquals("com.lametric.radio", app.getPackageName());
            assertEquals("LaMetric", app.getVendor());
            assertEquals("1.0.10", app.getVersion());
            assertEquals("22", app.getVersionCode());
            assertNull(app.getWidgets());
            assertNull(app.getActions());
        }
    }
}
