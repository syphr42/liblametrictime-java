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

import com.google.gson.annotations.SerializedName;

public enum SoundId
{
 @SerializedName("bicycle")
 BICYCLE(SoundCategory.NOTIFICATIONS),
 @SerializedName("car")
 CAR(SoundCategory.NOTIFICATIONS),
 @SerializedName("cash")
 CASH(SoundCategory.NOTIFICATIONS),
 @SerializedName("cat")
 CAT(SoundCategory.NOTIFICATIONS),
 @SerializedName("dog")
 DOG(SoundCategory.NOTIFICATIONS),
 @SerializedName("dog2")
 DOG2(SoundCategory.NOTIFICATIONS),
 @SerializedName("energy")
 ENERGY(SoundCategory.NOTIFICATIONS),
 @SerializedName("knock-knock")
 KNOCK_KNOCK(SoundCategory.NOTIFICATIONS),
 @SerializedName("letter_email")
 LETTER_EMAIL(SoundCategory.NOTIFICATIONS),
 @SerializedName("lose1")
 LOSE1(SoundCategory.NOTIFICATIONS),
 @SerializedName("lose2")
 LOSE2(SoundCategory.NOTIFICATIONS),
 @SerializedName("negative1")
 NEGATIVE1(SoundCategory.NOTIFICATIONS),
 @SerializedName("negative2")
 NEGATIVE2(SoundCategory.NOTIFICATIONS),
 @SerializedName("negative3")
 NEGATIVE3(SoundCategory.NOTIFICATIONS),
 @SerializedName("negative4")
 NEGATIVE4(SoundCategory.NOTIFICATIONS),
 @SerializedName("negative5")
 NEGATIVE5(SoundCategory.NOTIFICATIONS),
 @SerializedName("notification")
 NOTIFICATION(SoundCategory.NOTIFICATIONS),
 @SerializedName("notification2")
 NOTIFICATION2(SoundCategory.NOTIFICATIONS),
 @SerializedName("notification3")
 NOTIFICATION3(SoundCategory.NOTIFICATIONS),
 @SerializedName("notification4")
 NOTIFICATION4(SoundCategory.NOTIFICATIONS),
 @SerializedName("open_door")
 OPEN_DOOR(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive1")
 POSITIVE1(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive2")
 POSITIVE2(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive3")
 POSITIVE3(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive4")
 POSITIVE4(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive5")
 POSITIVE5(SoundCategory.NOTIFICATIONS),
 @SerializedName("positive6")
 POSITIVE6(SoundCategory.NOTIFICATIONS),
 @SerializedName("statistic")
 STATISTIC(SoundCategory.NOTIFICATIONS),
 @SerializedName("thunder")
 THUNDER(SoundCategory.NOTIFICATIONS),
 @SerializedName("water1")
 WATER1(SoundCategory.NOTIFICATIONS),
 @SerializedName("water2")
 WATER2(SoundCategory.NOTIFICATIONS),
 @SerializedName("win")
 WIN(SoundCategory.NOTIFICATIONS),
 @SerializedName("win2")
 WIN2(SoundCategory.NOTIFICATIONS),
 @SerializedName("wind")
 WIND(SoundCategory.NOTIFICATIONS),
 @SerializedName("wind_short")
 WIND_SHORT(SoundCategory.NOTIFICATIONS),

 @SerializedName("alarm1")
 ALARM1(SoundCategory.ALARMS),
 @SerializedName("alarm2")
 ALARM2(SoundCategory.ALARMS),
 @SerializedName("alarm3")
 ALARM3(SoundCategory.ALARMS),
 @SerializedName("alarm4")
 ALARM4(SoundCategory.ALARMS),
 @SerializedName("alarm5")
 ALARM5(SoundCategory.ALARMS),
 @SerializedName("alarm6")
 ALARM6(SoundCategory.ALARMS),
 @SerializedName("alarm7")
 ALARM7(SoundCategory.ALARMS),
 @SerializedName("alarm8")
 ALARM8(SoundCategory.ALARMS),
 @SerializedName("alarm9")
 ALARM9(SoundCategory.ALARMS),
 @SerializedName("alarm10")
 ALARM10(SoundCategory.ALARMS),
 @SerializedName("alarm11")
 ALARM11(SoundCategory.ALARMS),
 @SerializedName("alarm12")
 ALARM12(SoundCategory.ALARMS),
 @SerializedName("alarm13")
 ALARM13(SoundCategory.ALARMS);

    private final SoundCategory category;

    private SoundId(SoundCategory category)
    {
        this.category = category;
    }

    public SoundCategory getCategory()
    {
        return category;
    }
}
