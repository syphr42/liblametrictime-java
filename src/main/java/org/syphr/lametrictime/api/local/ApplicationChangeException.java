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
package org.syphr.lametrictime.api.local;

import org.syphr.lametrictime.api.local.model.Failure;

public class ApplicationChangeException extends LaMetricTimeException
{
    private static final long serialVersionUID = 1L;

    public ApplicationChangeException()
    {
        super();
    }

    public ApplicationChangeException(String message)
    {
        super(message);
    }

    public ApplicationChangeException(Throwable cause)
    {
        super(cause);
    }

    public ApplicationChangeException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ApplicationChangeException(String message,
                           Throwable cause,
                           boolean enableSuppression,
                           boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ApplicationChangeException(Failure failure)
    {
        super(failure);
    }
}