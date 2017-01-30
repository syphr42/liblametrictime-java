package org.syphr.lametrictime.api.local.model;

import static org.junit.Assert.assertEquals;

import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Test;
import org.syphr.lametrictime.api.common.impl.GsonGenerator;
import org.syphr.lametrictime.api.test.AbstractTest;

import com.google.gson.Gson;

public class GoalDataTest extends AbstractTest
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
        GoalData goalData = new GoalData().withStart(0).withEnd(100).withCurrent(50).withUnit("%");
        assertEquals(readJson("goal-data.json"), gson.toJson(goalData));
    }

    @Test
    public void testDeserializeSimple() throws Exception
    {
        try (FileReader reader = new FileReader(getTestDataFile("goal-data.json")))
        {
            GoalData goalData = gson.fromJson(reader, GoalData.class);
            assertEquals(Integer.valueOf(0), goalData.getStart());
            assertEquals(Integer.valueOf(100), goalData.getEnd());
            assertEquals(Integer.valueOf(50), goalData.getCurrent());
            assertEquals("%", goalData.getUnit());
        }
    }
}
