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

public class AudioUpdateResult
{
    private Success success;

    public Success getSuccess()
    {
        return success;
    }

    public void setSuccess(Success success)
    {
        this.success = success;
    }

    public AudioUpdateResult withSuccess(Success success)
    {
        this.success = success;
        return this;
    }

    public static class Success
    {
        private Audio data;

        public Audio getData()
        {
            return data;
        }

        public void setData(Audio data)
        {
            this.data = data;
        }

        public Success withData(Audio data)
        {
            this.data = data;
            return this;
        }
    }
}
