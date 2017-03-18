/*
 * Copyright 2017 Gregory Moyer
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

import org.syphr.lametrictime.api.local.model.UpdateAction;

public class CoreAction
{
    private final CoreApplication app;
    private final UpdateAction action;

    protected CoreAction(CoreApplication app, UpdateAction action)
    {
        this.app = app;
        this.action = action;
    }

    public CoreApplication getApp()
    {
        return app;
    }

    public UpdateAction getAction()
    {
        return action;
    }
}
