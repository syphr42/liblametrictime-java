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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "apps_action_url",
                     "apps_get_url",
                     "apps_list_url",
                     "apps_switch_next_url",
                     "apps_switch_prev_url",
                     "apps_switch_url",
                     "audio_url",
                     "bluetooth_url",
                     "concrete_notification_url",
                     "current_notification_url",
                     "device_url",
                     "display_url",
                     "notifications_url",
                     "widget_update_url",
                     "wifi_url" })
public class Endpoints
{
    @JsonProperty("apps_action_url")
    private String appsActionUrl;
    @JsonProperty("apps_get_url")
    private String appsGetUrl;
    @JsonProperty("apps_list_url")
    private String appsListUrl;
    @JsonProperty("apps_switch_next_url")
    private String appsSwitchNextUrl;
    @JsonProperty("apps_switch_prev_url")
    private String appsSwitchPrevUrl;
    @JsonProperty("apps_switch_url")
    private String appsSwitchUrl;
    @JsonProperty("audio_url")
    private String audioUrl;
    @JsonProperty("bluetooth_url")
    private String bluetoothUrl;
    @JsonProperty("concrete_notification_url")
    private String concreteNotificationUrl;
    @JsonProperty("current_notification_url")
    private String currentNotificationUrl;
    @JsonProperty("device_url")
    private String deviceUrl;
    @JsonProperty("display_url")
    private String displayUrl;
    @JsonProperty("notifications_url")
    private String notificationsUrl;
    @JsonProperty("widget_update_url")
    private String widgetUpdateUrl;
    @JsonProperty("wifi_url")
    private String wifiUrl;

    @JsonProperty("apps_action_url")
    public String getAppsActionUrl()
    {
        return appsActionUrl;
    }

    @JsonProperty("apps_action_url")
    public void setAppsActionUrl(String appsActionUrl)
    {
        this.appsActionUrl = appsActionUrl;
    }

    public Endpoints withAppsActionUrl(String appsActionUrl)
    {
        this.appsActionUrl = appsActionUrl;
        return this;
    }

    @JsonProperty("apps_get_url")
    public String getAppsGetUrl()
    {
        return appsGetUrl;
    }

    @JsonProperty("apps_get_url")
    public void setAppsGetUrl(String appsGetUrl)
    {
        this.appsGetUrl = appsGetUrl;
    }

    public Endpoints withAppsGetUrl(String appsGetUrl)
    {
        this.appsGetUrl = appsGetUrl;
        return this;
    }

    @JsonProperty("apps_list_url")
    public String getAppsListUrl()
    {
        return appsListUrl;
    }

    @JsonProperty("apps_list_url")
    public void setAppsListUrl(String appsListUrl)
    {
        this.appsListUrl = appsListUrl;
    }

    public Endpoints withAppsListUrl(String appsListUrl)
    {
        this.appsListUrl = appsListUrl;
        return this;
    }

    @JsonProperty("apps_switch_next_url")
    public String getAppsSwitchNextUrl()
    {
        return appsSwitchNextUrl;
    }

    @JsonProperty("apps_switch_next_url")
    public void setAppsSwitchNextUrl(String appsSwitchNextUrl)
    {
        this.appsSwitchNextUrl = appsSwitchNextUrl;
    }

    public Endpoints withAppsSwitchNextUrl(String appsSwitchNextUrl)
    {
        this.appsSwitchNextUrl = appsSwitchNextUrl;
        return this;
    }

    @JsonProperty("apps_switch_prev_url")
    public String getAppsSwitchPrevUrl()
    {
        return appsSwitchPrevUrl;
    }

    @JsonProperty("apps_switch_prev_url")
    public void setAppsSwitchPrevUrl(String appsSwitchPrevUrl)
    {
        this.appsSwitchPrevUrl = appsSwitchPrevUrl;
    }

    public Endpoints withAppsSwitchPrevUrl(String appsSwitchPrevUrl)
    {
        this.appsSwitchPrevUrl = appsSwitchPrevUrl;
        return this;
    }

    @JsonProperty("apps_switch_url")
    public String getAppsSwitchUrl()
    {
        return appsSwitchUrl;
    }

    @JsonProperty("apps_switch_url")
    public void setAppsSwitchUrl(String appsSwitchUrl)
    {
        this.appsSwitchUrl = appsSwitchUrl;
    }

    public Endpoints withAppsSwitchUrl(String appsSwitchUrl)
    {
        this.appsSwitchUrl = appsSwitchUrl;
        return this;
    }

    @JsonProperty("audio_url")
    public String getAudioUrl()
    {
        return audioUrl;
    }

    @JsonProperty("audio_url")
    public void setAudioUrl(String audioUrl)
    {
        this.audioUrl = audioUrl;
    }

    public Endpoints withAudioUrl(String audioUrl)
    {
        this.audioUrl = audioUrl;
        return this;
    }

    @JsonProperty("bluetooth_url")
    public String getBluetoothUrl()
    {
        return bluetoothUrl;
    }

    @JsonProperty("bluetooth_url")
    public void setBluetoothUrl(String bluetoothUrl)
    {
        this.bluetoothUrl = bluetoothUrl;
    }

    public Endpoints withBluetoothUrl(String bluetoothUrl)
    {
        this.bluetoothUrl = bluetoothUrl;
        return this;
    }

    @JsonProperty("concrete_notification_url")
    public String getConcreteNotificationUrl()
    {
        return concreteNotificationUrl;
    }

    @JsonProperty("concrete_notification_url")
    public void setConcreteNotificationUrl(String concreteNotificationUrl)
    {
        this.concreteNotificationUrl = concreteNotificationUrl;
    }

    public Endpoints withConcreteNotificationUrl(String concreteNotificationUrl)
    {
        this.concreteNotificationUrl = concreteNotificationUrl;
        return this;
    }

    @JsonProperty("current_notification_url")
    public String getCurrentNotificationUrl()
    {
        return currentNotificationUrl;
    }

    @JsonProperty("current_notification_url")
    public void setCurrentNotificationUrl(String currentNotificationUrl)
    {
        this.currentNotificationUrl = currentNotificationUrl;
    }

    public Endpoints withCurrentNotificationUrl(String currentNotificationUrl)
    {
        this.currentNotificationUrl = currentNotificationUrl;
        return this;
    }

    @JsonProperty("device_url")
    public String getDeviceUrl()
    {
        return deviceUrl;
    }

    @JsonProperty("device_url")
    public void setDeviceUrl(String deviceUrl)
    {
        this.deviceUrl = deviceUrl;
    }

    public Endpoints withDeviceUrl(String deviceUrl)
    {
        this.deviceUrl = deviceUrl;
        return this;
    }

    @JsonProperty("display_url")
    public String getDisplayUrl()
    {
        return displayUrl;
    }

    @JsonProperty("display_url")
    public void setDisplayUrl(String displayUrl)
    {
        this.displayUrl = displayUrl;
    }

    public Endpoints withDisplayUrl(String displayUrl)
    {
        this.displayUrl = displayUrl;
        return this;
    }

    @JsonProperty("notifications_url")
    public String getNotificationsUrl()
    {
        return notificationsUrl;
    }

    @JsonProperty("notifications_url")
    public void setNotificationsUrl(String notificationsUrl)
    {
        this.notificationsUrl = notificationsUrl;
    }

    public Endpoints withNotificationsUrl(String notificationsUrl)
    {
        this.notificationsUrl = notificationsUrl;
        return this;
    }

    @JsonProperty("widget_update_url")
    public String getWidgetUpdateUrl()
    {
        return widgetUpdateUrl;
    }

    @JsonProperty("widget_update_url")
    public void setWidgetUpdateUrl(String widgetUpdateUrl)
    {
        this.widgetUpdateUrl = widgetUpdateUrl;
    }

    public Endpoints withWidgetUpdateUrl(String widgetUpdateUrl)
    {
        this.widgetUpdateUrl = widgetUpdateUrl;
        return this;
    }

    @JsonProperty("wifi_url")
    public String getWifiUrl()
    {
        return wifiUrl;
    }

    @JsonProperty("wifi_url")
    public void setWifiUrl(String wifiUrl)
    {
        this.wifiUrl = wifiUrl;
    }

    public Endpoints withWifiUrl(String wifiUrl)
    {
        this.wifiUrl = wifiUrl;
        return this;
    }
}
