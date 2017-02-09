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
import org.syphr.lametrictime.api.CoreApps;
import org.syphr.lametrictime.api.LaMetricTime;
import org.syphr.lametrictime.api.cloud.CloudConfiguration;
import org.syphr.lametrictime.api.cloud.LaMetricTimeCloud;
import org.syphr.lametrictime.api.local.ApplicationActionException;
import org.syphr.lametrictime.api.local.ApplicationActivationException;
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
import org.syphr.lametrictime.api.local.model.UpdateAction;

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
