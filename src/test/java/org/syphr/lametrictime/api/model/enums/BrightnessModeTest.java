/**
 * Copyright 2017-2018 Gregory Moyer and contributors.
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
package org.syphr.lametrictime.api.model.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.syphr.lametrictime.api.model.enums.BrightnessMode;

public class BrightnessModeTest
{
    @Test
    public void testConversion()
    {
        for (BrightnessMode value : BrightnessMode.values())
        {
            assertEquals(value, BrightnessMode.toEnum(value.toRaw()));
        }
    }

    @Test
    public void testInvalidRawValue()
    {
        assertNull(BrightnessMode.toEnum("invalid raw value"));
    }

    @Test
    public void testNullRawValue()
    {
        assertNull(BrightnessMode.toEnum(null));
    }
}
