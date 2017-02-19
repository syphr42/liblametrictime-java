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
package org.syphr.lametrictime.api.model.enums;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class WifiEncryptionTest
{
    @Test
    public void testConversion()
    {
        for (WifiEncryption value : WifiEncryption.values())
        {
            assertEquals(value, WifiEncryption.toEnum(value.toRaw()));
        }
    }

    @Test
    public void testInvalidRawValue()
    {
        assertNull(WifiEncryption.toEnum("invalid raw value"));
    }

    @Test
    public void testNullRawValue()
    {
        assertNull(WifiEncryption.toEnum(null));
    }
}
