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

public class ApplicationsTest extends AbstractTest
{
    private static Gson gson;

    @BeforeClass
    public static void setUpBeforeClass()
    {
        gson = GsonGenerator.create(true);
    }

    @Test
    public void testSerialize() throws Exception
    {
        Applications apps = new Applications().withList(Arrays.asList(new Application().withId("com.lametric.clock"),
                                                                      new Application().withId("com.lametric.countdown")));
        assertEquals(readJson("applications.json"), gson.toJson(apps));
    }

    @Test
    public void testDeserialize() throws Exception
    {
        try (FileReader reader = new FileReader(getTestDataFile("applications.json")))
        {
            Applications apps = gson.fromJson(reader, Applications.class);

            List<Application> appList = apps.getList();
            assertNotNull(appList);
            assertEquals(2, appList.size());
            assertEquals("com.lametric.clock", appList.get(0).getId());
            assertEquals("com.lametric.countdown", appList.get(1).getId());
        }
    }
}
