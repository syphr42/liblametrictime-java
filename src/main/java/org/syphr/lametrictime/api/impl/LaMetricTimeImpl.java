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
package org.syphr.lametrictime.api.impl;

import java.util.Arrays;

import org.syphr.lametrictime.api.Configuration;
import org.syphr.lametrictime.api.LaMetricTime;
import org.syphr.lametrictime.api.cloud.CloudConfiguration;
import org.syphr.lametrictime.api.cloud.LaMetricTimeCloud;
import org.syphr.lametrictime.api.local.ApplicationChangeException;
import org.syphr.lametrictime.api.local.ApplicationNotFoundException;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.LocalConfiguration;
import org.syphr.lametrictime.api.local.NotificationCreationException;
import org.syphr.lametrictime.api.local.model.Application;
import org.syphr.lametrictime.api.local.model.Frame;
import org.syphr.lametrictime.api.local.model.Notification;
import org.syphr.lametrictime.api.local.model.NotificationModel;
import org.syphr.lametrictime.api.local.model.Priority;
import org.syphr.lametrictime.api.local.model.Sound;
import org.syphr.lametrictime.api.local.model.SoundId;

public class LaMetricTimeImpl implements LaMetricTime
{
    private final LaMetricTimeLocal local;
    private final LaMetricTimeCloud cloud;

    public LaMetricTimeImpl(Configuration config)
    {
        this(config.getLocalConfig(), config.getCloudConfig());
    }

    public LaMetricTimeImpl(LocalConfiguration localConfig, CloudConfiguration cloudConfig)
    {
        this.local = LaMetricTimeLocal.create(localConfig);
        this.cloud = LaMetricTimeCloud.create(cloudConfig);
    }

    @Override
    public String getVersion()
    {
        return local.getApi().getApiVersion();
    }

    @Override
    public String notifyInfo(String message) throws NotificationCreationException
    {
        return local.createNotification(new Notification().withPriority(Priority.INFO)
                                                          .withModel(new NotificationModel().withCycles(1)
                                                                                            .withSound(new Sound().withCategoryAndId(SoundId.NOTIFICATION))
                                                                                            .withFrames(Arrays.asList(new Frame().withText(message)
                                                                                                                                 .withIcon("i1248")))));
    }

    @Override
    public String notifyImportant(String message) throws NotificationCreationException
    {
        return local.createNotification(new Notification().withPriority(Priority.WARNING)
                                                          .withModel(new NotificationModel().withCycles(2)
                                                                                            .withSound(new Sound().withCategoryAndId(SoundId.NOTIFICATION2))
                                                                                            .withFrames(Arrays.asList(new Frame().withText(message)
                                                                                                                                 .withIcon("a2098")))));
    }

    @Override
    public String notifyCritical(String message) throws NotificationCreationException
    {
        return local.createNotification(new Notification().withPriority(Priority.CRITICAL)
                                                          .withModel(new NotificationModel().withCycles(3)
                                                                                            .withSound(new Sound().withCategoryAndId(SoundId.ALARM1))
                                                                                            .withFrames(Arrays.asList(new Frame().withText(message)
                                                                                                                                 .withIcon("a4787")))));
    }

    @Override
    public void activateClock()
    {
        activateCoreApplication(CoreApplication.CLOCK);
    }

    @Override
    public void activateCountdown()
    {
        activateCoreApplication(CoreApplication.COUNTDOWN);
    }

    @Override
    public void activateRadio()
    {
        activateCoreApplication(CoreApplication.RADIO);
    }

    @Override
    public void activateStopwatch()
    {
        activateCoreApplication(CoreApplication.STOPWATCH);
    }

    @Override
    public void activateWeather()
    {
        activateCoreApplication(CoreApplication.WEATHER);
    }

    protected void activateCoreApplication(CoreApplication coreApp)
    {
        String packageName = coreApp.getPackageName();
        try
        {
            Application app = getLocalApi().getApplication(packageName);
            getLocalApi().activateApplication(packageName, app.getWidgets().firstKey());
        }
        catch (ApplicationNotFoundException | ApplicationChangeException e)
        {
            // core apps should never throw errors
            throw new RuntimeException("Failed to activate core application: " + packageName, e);
        }
    }

    @Override
    public LaMetricTimeLocal getLocalApi()
    {
        return local;
    }

    @Override
    public LaMetricTimeCloud getCloudApi()
    {
        return cloud;
    }
}
