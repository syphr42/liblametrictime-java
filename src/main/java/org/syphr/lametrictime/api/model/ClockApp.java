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
package org.syphr.lametrictime.api.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.SortedMap;
import java.util.TreeMap;

import org.syphr.lametrictime.api.local.model.BooleanParameter;
import org.syphr.lametrictime.api.local.model.Parameter;
import org.syphr.lametrictime.api.local.model.StringParameter;
import org.syphr.lametrictime.api.local.model.UpdateAction;

public class ClockApp extends CoreApplication
{
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");

    private static final String NAME = "com.lametric.clock";

    private static final String ACTION_ALARM = "clock.alarm";

    private static final String PARAMETER_ENABLED = "enabled";
    private static final String PARAMETER_TIME = "time";
    private static final String PARAMETER_WAKE_WITH_RADIO = "wake_with_radio";

    public ClockApp()
    {
        super(NAME);
    }

    public CoreAction setAlarm(boolean enabled, LocalTime time, boolean wakeWithRadio)
    {
        SortedMap<String, Parameter> parameters = new TreeMap<>();
        parameters.put(PARAMETER_ENABLED, new BooleanParameter().withValue(enabled));
        parameters.put(PARAMETER_WAKE_WITH_RADIO, new BooleanParameter().withValue(wakeWithRadio));

        if (time != null)
        {
            parameters.put(PARAMETER_TIME,
                           new StringParameter().withValue(time.format(TIME_FORMATTER)));
        }

        return new CoreAction(this,
                              new UpdateAction().withId(ACTION_ALARM).withParameters(parameters));
    }

    public CoreAction snooze()
    {
        SortedMap<String, Parameter> parameters = new TreeMap<>();
        parameters.put(PARAMETER_ENABLED, new BooleanParameter().withValue(true));
        parameters.put(PARAMETER_TIME, new StringParameter().withValue(LocalTime.now()
                                                                                .plusMinutes(10)
                                                                                .format(TIME_FORMATTER)));

        return new CoreAction(this,
                              new UpdateAction().withId(ACTION_ALARM).withParameters(parameters));
    }

    public CoreAction stopAlarm()
    {
        SortedMap<String, Parameter> parameters = new TreeMap<>();
        parameters.put(PARAMETER_ENABLED, new BooleanParameter().withValue(false));

        return new CoreAction(this,
                              new UpdateAction().withId(ACTION_ALARM).withParameters(parameters));
    }
}
