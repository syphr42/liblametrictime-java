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

import java.io.File;
import java.net.URI;
import java.nio.file.Path;

import org.syphr.lametrictime.api.impl.DataIcon;
import org.syphr.lametrictime.api.impl.FileIcon;
import org.syphr.lametrictime.api.impl.HTTPIcon;
import org.syphr.lametrictime.api.impl.KeyIcon;

public class Icons
{
    public static Icon key(String key)
    {
        return new KeyIcon(key);
    }

    public static Icon http(String uri)
    {
        return http(URI.create(uri));
    }

    public static Icon http(URI uri)
    {
        return new HTTPIcon(uri);
    }

    public static Icon path(Path path)
    {
        return new FileIcon(path);
    }

    public static Icon file(File file)
    {
        return new FileIcon(file);
    }

    public static Icon data(String mimeType, byte[] data)
    {
        return new DataIcon(mimeType, data);
    }

    // @formatter:off
    public static Icon dollar() { return key("i34"); }
    public static Icon gmail() { return key("i43"); }
    public static Icon confirm() { return key("i59"); }
    public static Icon goOut() { return key("a68"); }
    public static Icon dog() { return key("a76"); }
    public static Icon clock() { return key("a82"); }
    public static Icon smile() { return key("a87"); }
    public static Icon lightning() { return key("i95"); }
    public static Icon facebook() { return key("a128"); }
    public static Icon home() { return key("i96"); }
    public static Icon girl() { return key("a178"); }
    public static Icon stop() { return key("i184"); }
    public static Icon heart() { return key("a230"); }
    public static Icon fade() { return key("a273"); }
    public static Icon terminal() { return key("a315"); }
    public static Icon usa() { return key("a413"); }
    public static Icon switzerland() { return key("i469"); }
    public static Icon attention() { return key("i555"); }
    public static Icon theMatrix() { return key("a653"); }
    public static Icon pizza() { return key("i1324"); }
    public static Icon christmasTree() { return key("a1782"); }
    public static Icon night() { return key("a2285"); }
    public static Icon fireworks() { return key("a2867"); }
    public static Icon beer() { return key("i3253"); }
    public static Icon tetris() { return key("a3793"); }
    public static Icon halloween() { return key("a4033"); }
    public static Icon pacman() { return key("a4584"); }

    private Icons() {}
    // @formatter:on
}
