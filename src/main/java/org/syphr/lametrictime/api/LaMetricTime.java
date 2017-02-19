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
import org.syphr.lametrictime.api.local.ApplicationActionException;
import org.syphr.lametrictime.api.local.ApplicationActivationException;
import org.syphr.lametrictime.api.local.ApplicationNotFoundException;
import org.syphr.lametrictime.api.local.LaMetricTimeLocal;
import org.syphr.lametrictime.api.local.LocalConfiguration;
import org.syphr.lametrictime.api.local.NotificationCreationException;
import org.syphr.lametrictime.api.local.UpdateException;
import org.syphr.lametrictime.api.local.model.Application;
import org.syphr.lametrictime.api.local.model.Display;
import org.syphr.lametrictime.api.local.model.UpdateAction;
import org.syphr.lametrictime.api.model.BrightnessMode;
import org.syphr.lametrictime.api.model.CoreAction;
import org.syphr.lametrictime.api.model.CoreApplication;
import org.syphr.lametrictime.api.model.Icon;
import org.syphr.lametrictime.api.model.Priority;
import org.syphr.lametrictime.api.model.Sound;

public interface LaMetricTime
{
    public String getVersion();

    /**
     * Send a low priority message to the device.
     *
     * @param message
     *            the text to display
     * @return the identifier of the newly created notification
     * @throws NotificationCreationException
     *             if there is a communication error or malformed data
     */
    public String notifyInfo(String message) throws NotificationCreationException;

    /**
     * Send a medium priority message to the device.
     *
     * @param message
     *            the text to display
     * @return the identifier of the newly created notification
     * @throws NotificationCreationException
     *             if there is a communication error or malformed data
     */
    public String notifyWarning(String message) throws NotificationCreationException;

    /**
     * Send an urgent message to the device. The notification will not be
     * automatically removed. The user will be required to dismiss this
     * notification or it must be deleted through he API.
     *
     * @param message
     *            the text to display
     * @return the identifier of the newly created notification
     * @throws NotificationCreationException
     *             if there is a communication error or malformed data
     */
    public String notifyCritical(String message) throws NotificationCreationException;

    /**
     * Send a notification to the device.
     *
     * Priority is important. It defines the urgency of this notification as
     * related to others in the queue and the current state of the device.
     * <ol>
     * <li>{@link Priority#INFO}: lowest priority; not shown when the
     * screensaver is active; waits for its turn in the queue
     * <li>{@link Priority#WARNING}: middle priority; not shown when the
     * screensaver is active; preempts {@link Priority#INFO}
     * <li>{@link Priority#CRITICAL}: highest priority; shown even when the
     * screensaver is active; preempts all other notifications (to be used
     * sparingly)
     * </ol>
     *
     * @param message
     *            the text to display
     * @param priority
     *            the urgency of this notification; defaults to
     *            {@link Priority#INFO}
     * @param icon
     *            the icon to display next to the message; can be
     *            <code>null</code>
     * @param sound
     *            the sound to play when the notification is displayed; can be
     *            <code>null</code>
     * @param messageRepeat
     *            the number of times the message should be displayed before
     *            being removed (use <code>0</code> to leave the notification on
     *            the device until it is dismissed by the user or deleted
     *            through the API)
     * @param soundRepeat
     *            the number of times to repeat the sound (use <code>0</code> to
     *            keep the sound looping until the notification is dismissed by
     *            the user or deleted through the API)
     * @return the identifier of the newly created notification
     * @throws NotificationCreationException
     *             if there is a communication error or malformed data
     */
    public String notify(String message,
                         Priority priority,
                         Icon icon,
                         Sound sound,
                         int messageRepeat,
                         int soundRepeat) throws NotificationCreationException;

    public Application getClock();

    public Application getCountdown();

    public Application getRadio();

    public Application getStopwatch();

    public Application getWeather();

    public Application getApplication(CoreApplication coreApp);

    public Application getApplication(String name) throws ApplicationNotFoundException;

    public void activateApplication(CoreApplication coreApp);

    public void activateApplication(Application app) throws ApplicationActivationException;

    public void doAction(CoreAction coreAction);

    public void doAction(Application app, UpdateAction action) throws ApplicationActionException;

    public Display setBrightness(int brightness) throws UpdateException;

    public Display setBrightnessMode(BrightnessMode mode) throws UpdateException;

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
