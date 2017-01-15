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

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SoundId
{
 @JsonProperty("bicycle")
 BICYCLE(SoundCategory.NOTIFICATIONS),
 @JsonProperty("car")
 CAR(SoundCategory.NOTIFICATIONS),
 @JsonProperty("cash")
 CASH(SoundCategory.NOTIFICATIONS),
 @JsonProperty("cat")
 CAT(SoundCategory.NOTIFICATIONS),
 @JsonProperty("dog")
 DOG(SoundCategory.NOTIFICATIONS),
 @JsonProperty("dog2")
 DOG2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("energy")
 ENERGY(SoundCategory.NOTIFICATIONS),
 @JsonProperty("knock-knock")
 KNOCK_KNOCK(SoundCategory.NOTIFICATIONS),
 @JsonProperty("letter_email")
 LETTER_EMAIL(SoundCategory.NOTIFICATIONS),
 @JsonProperty("lose1")
 LOSE1(SoundCategory.NOTIFICATIONS),
 @JsonProperty("lose2")
 LOSE2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("negative1")
 NEGATIVE1(SoundCategory.NOTIFICATIONS),
 @JsonProperty("negative2")
 NEGATIVE2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("negative3")
 NEGATIVE3(SoundCategory.NOTIFICATIONS),
 @JsonProperty("negative4")
 NEGATIVE4(SoundCategory.NOTIFICATIONS),
 @JsonProperty("negative5")
 NEGATIVE5(SoundCategory.NOTIFICATIONS),
 @JsonProperty("notification")
 NOTIFICATION(SoundCategory.NOTIFICATIONS),
 @JsonProperty("notification2")
 NOTIFICATION2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("notification3")
 NOTIFICATION3(SoundCategory.NOTIFICATIONS),
 @JsonProperty("notification4")
 NOTIFICATION4(SoundCategory.NOTIFICATIONS),
 @JsonProperty("open_door")
 OPEN_DOOR(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive1")
 POSITIVE1(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive2")
 POSITIVE2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive3")
 POSITIVE3(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive4")
 POSITIVE4(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive5")
 POSITIVE5(SoundCategory.NOTIFICATIONS),
 @JsonProperty("positive6")
 POSITIVE6(SoundCategory.NOTIFICATIONS),
 @JsonProperty("statistic")
 STATISTIC(SoundCategory.NOTIFICATIONS),
 @JsonProperty("thunder")
 THUNDER(SoundCategory.NOTIFICATIONS),
 @JsonProperty("water1")
 WATER1(SoundCategory.NOTIFICATIONS),
 @JsonProperty("water2")
 WATER2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("win")
 WIN(SoundCategory.NOTIFICATIONS),
 @JsonProperty("win2")
 WIN2(SoundCategory.NOTIFICATIONS),
 @JsonProperty("wind")
 WIND(SoundCategory.NOTIFICATIONS),
 @JsonProperty("wind_short")
 WIND_SHORT(SoundCategory.NOTIFICATIONS),

 @JsonProperty("alarm1")
 ALARM1(SoundCategory.ALARMS),
 @JsonProperty("alarm2")
 ALARM2(SoundCategory.ALARMS),
 @JsonProperty("alarm3")
 ALARM3(SoundCategory.ALARMS),
 @JsonProperty("alarm4")
 ALARM4(SoundCategory.ALARMS),
 @JsonProperty("alarm5")
 ALARM5(SoundCategory.ALARMS),
 @JsonProperty("alarm6")
 ALARM6(SoundCategory.ALARMS),
 @JsonProperty("alarm7")
 ALARM7(SoundCategory.ALARMS),
 @JsonProperty("alarm8")
 ALARM8(SoundCategory.ALARMS),
 @JsonProperty("alarm9")
 ALARM9(SoundCategory.ALARMS),
 @JsonProperty("alarm10")
 ALARM10(SoundCategory.ALARMS),
 @JsonProperty("alarm11")
 ALARM11(SoundCategory.ALARMS),
 @JsonProperty("alarm12")
 ALARM12(SoundCategory.ALARMS),
 @JsonProperty("alarm13")
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
