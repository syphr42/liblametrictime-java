/*
 * Copyright 2017 Gregory Moyer
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
package org.syphr.lametrictime.api.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractTest
{
    protected File getTestDataFile(String name)
    {
        return getTestDataPath(name).toFile();
    }

    protected Path getTestDataPath(String name)
    {
        return TestUtil.getTestDataPath(this.getClass(), name);
    }

    protected String readJson(String jsonFileName) throws IOException
    {
        return new String(Files.readAllBytes(getTestDataPath(jsonFileName)));
    }
}
