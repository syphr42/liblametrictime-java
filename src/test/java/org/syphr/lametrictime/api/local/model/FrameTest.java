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

import static org.junit.Assert.assertEquals;

import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Test;
import org.syphr.lametrictime.api.common.impl.GsonGenerator;
import org.syphr.lametrictime.api.test.AbstractTest;

import com.google.gson.Gson;

public class FrameTest extends AbstractTest
{
    private static Gson gson;

    @BeforeClass
    public static void setUpBeforeClass()
    {
        gson = GsonGenerator.create(true);
    }

    @Test
    public void testSerializeSimple() throws Exception
    {
        Frame frame = new Frame().withIcon("i87").withText("Hello world!");
        assertEquals(readJson("frame-simple.json"), gson.toJson(frame));
    }

    @Test
    public void testDeserializeSimple() throws Exception
    {
        try (FileReader reader = new FileReader(getTestDataFile("frame-simple.json")))
        {
            Frame frame = gson.fromJson(reader, Frame.class);
            assertEquals("i87", frame.getIcon());
            assertEquals("Hello world!", frame.getText());
            assertEquals(null, frame.getGoalData());
            assertEquals(null, frame.getChartData());
        }
    }

    // TODO goal
    // TODO spike chart
}
