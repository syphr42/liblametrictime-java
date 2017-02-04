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
package org.syphr.lametrictime.api;

import org.syphr.lametrictime.api.cloud.CloudConfiguration;
import org.syphr.lametrictime.api.cloud.LaMetricTimeCloud;
import org.syphr.lametrictime.api.impl.LaMetricTimeImpl;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.LocalConfiguration;
import org.syphr.lametrictime.api.local.NotificationCreationException;

public interface LaMetricTime
{
    public String getVersion();

    public String notifyInfo(String message) throws NotificationCreationException;

    public String notifyImportant(String message) throws NotificationCreationException;

    public String notifyCritical(String message) throws NotificationCreationException;

    public void activateClock();

    public void activateCountdown();

    public void activateRadio();

    public void activateStopwatch();

    public void activateWeather();

    public void showWeatherForecast();

    public LaMetricTimeLocal getLocalApi();

    public LaMetricTimeCloud getCloudApi();

    public static LaMetricTime create(Configuration config)
    {
        return new LaMetricTimeImpl(config);
    }

    public static LaMetricTime create(LocalConfiguration localConfig,
                                      CloudConfiguration cloudConfig)
    {
        return new LaMetricTimeImpl(localConfig, cloudConfig);
    }
}
