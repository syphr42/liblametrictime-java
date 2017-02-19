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

import static org.syphr.lametrictime.api.model.ApiValue.raw;

import java.util.Arrays;

import org.syphr.lametrictime.api.Configuration;
import org.syphr.lametrictime.api.LaMetricTime;
import org.syphr.lametrictime.api.cloud.CloudConfiguration;
import org.syphr.lametrictime.api.cloud.LaMetricTimeCloud;
import org.syphr.lametrictime.api.local.ApplicationActionException;
import org.syphr.lametrictime.api.local.ApplicationActivationException;
import org.syphr.lametrictime.api.local.ApplicationNotFoundException;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.LocalConfiguration;
import org.syphr.lametrictime.api.local.NotificationCreationException;
import org.syphr.lametrictime.api.local.UpdateException;
import org.syphr.lametrictime.api.local.model.Application;
import org.syphr.lametrictime.api.local.model.Display;
import org.syphr.lametrictime.api.local.model.Frame;
import org.syphr.lametrictime.api.local.model.Notification;
import org.syphr.lametrictime.api.local.model.NotificationModel;
import org.syphr.lametrictime.api.local.model.UpdateAction;
import org.syphr.lametrictime.api.model.BrightnessMode;
import org.syphr.lametrictime.api.model.CoreAction;
import org.syphr.lametrictime.api.model.CoreApplication;
import org.syphr.lametrictime.api.model.CoreApps;
import org.syphr.lametrictime.api.model.Icon;
import org.syphr.lametrictime.api.model.Icons;
import org.syphr.lametrictime.api.model.Priority;
import org.syphr.lametrictime.api.model.Sound;

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
        return notify(message, Priority.INFO, Icons.key("i1248"), Sound.NOTIFICATION, 1, 1);
    }

    @Override
    public String notifyWarning(String message) throws NotificationCreationException
    {
        return notify(message, Priority.WARNING, Icons.key("a2098"), Sound.NOTIFICATION2, 2, 2);
    }

    @Override
    public String notifyCritical(String message) throws NotificationCreationException
    {
        return notify(message, Priority.CRITICAL, Icons.key("a4787"), Sound.ALARM1, 0, 0);
    }

    @Override
    public String notify(String message,
                         Priority priority,
                         Icon icon,
                         Sound sound,
                         int messageRepeat,
                         int soundRepeat) throws NotificationCreationException
    {
        // @formatter:off
        NotificationModel model = new NotificationModel()
                                      .withCycles(messageRepeat)
                                      .withFrames(Arrays.asList(new Frame().withText(message)
                                                                           .withIcon(raw(icon))));
        if (sound != null)
        {
            model.setSound(new org.syphr.lametrictime.api.local.model.Sound()
                               .withCategory(raw(sound.getCategory()))
                               .withId(raw(sound))
                               .withRepeat(soundRepeat));
        }
        // @formatter:on

        Notification notification = new Notification().withPriority(raw(priority)).withModel(model);
        return local.createNotification(notification);
    }

    @Override
    public Application getClock()
    {
        return getApplication(CoreApps.clock());
    }

    @Override
    public Application getCountdown()
    {
        return getApplication(CoreApps.countdown());
    }

    @Override
    public Application getRadio()
    {
        return getApplication(CoreApps.radio());
    }

    @Override
    public Application getStopwatch()
    {
        return getApplication(CoreApps.stopwatch());
    }

    @Override
    public Application getWeather()
    {
        return getApplication(CoreApps.weather());
    }

    @Override
    public Application getApplication(CoreApplication coreApp)
    {
        try
        {
            return getLocalApi().getApplication(coreApp.getPackageName());
        }
        catch (ApplicationNotFoundException e)
        {
            // core apps should never throw errors
            throw new RuntimeException("Failed to retrieve core application: "
                                       + coreApp.getPackageName(),
                                       e);
        }
    }

    @Override
    public Application getApplication(String name) throws ApplicationNotFoundException
    {
        return getLocalApi().getApplication(name);
    }

    @Override
    public void activateApplication(CoreApplication coreApp)
    {
        try
        {
            activateApplication(getApplication(coreApp));
        }
        catch (ApplicationActivationException e)
        {
            // core apps should never throw errors
            throw new RuntimeException("Failed to activate core application: "
                                       + coreApp.getPackageName(),
                                       e);
        }
    }

    @Override
    public void activateApplication(Application app) throws ApplicationActivationException
    {
        getLocalApi().activateApplication(app.getPackageName(), getFirstWidgetId(app));
    }

    @Override
    public void doAction(CoreAction coreAction)
    {
        try
        {
            doAction(getApplication(coreAction.getApp()), coreAction.getAction());
        }
        catch (ApplicationActionException e)
        {
            // core apps should never throw errors
            throw new RuntimeException("Failed to execute weather forecast action", e);
        }
    }

    @Override
    public void doAction(Application app, UpdateAction action) throws ApplicationActionException
    {
        getLocalApi().doAction(app.getPackageName(), getFirstWidgetId(app), action);
    }

    protected String getFirstWidgetId(Application app)
    {
        return app.getWidgets().firstKey();
    }

    @Override
    public Display setBrightness(int brightness) throws UpdateException
    {
        return local.updateDisplay(new Display().withBrightness(brightness)
                                                .withBrightnessMode(raw(BrightnessMode.MANUAL)));
    }

    @Override
    public Display setBrightnessMode(BrightnessMode mode) throws UpdateException
    {
        return local.updateDisplay(new Display().withBrightnessMode(raw(mode)));
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
