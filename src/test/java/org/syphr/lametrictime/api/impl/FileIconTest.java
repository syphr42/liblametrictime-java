package org.syphr.lametrictime.api.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.syphr.lametrictime.api.test.AbstractTest;

public class FileIconTest extends AbstractTest
{
    @Test
    public void testLocalPathGif()
    {
        FileIcon icon = new FileIcon(getTestDataPath("smile.gif"));
        assertEquals("data:image/gif;base64,R0lGODlhCAAIAPEAAPz+BPz+/AAAAAAAACH5BAkKAAIAIf8LTkVUU0NBUEUyLjADAQAAACwAAAAACAAIAAACEZSAYJfIElREIdaGs3PPNFMAACH5BAkKAAIALAAAAAAIAAgAAAIRlIBgl8gSVEQh1oazU4szJxQAIfkECTIAAgAsAAAAAAgACAAAAhKUgGCXyBJURCHWhlU7fCmzCQUAIfkECRQAAgAsAAAAAAgACAAAAhGUgGCXyBIaClFa1Y5eymRRAAAh+QQJMgACACwAAAAACAAIAAACEpSAYJfIElREIdaGVTt8KbMJBQA7",
                     icon.toRaw());
    }

    @Test
    public void testLocalPathPng()
    {
        FileIcon icon = new FileIcon(getTestDataPath("info.png"));
        assertEquals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAICAYAAADED76LAAAAL0lEQVQYlWN0NPv3nwEPYIEx9p1kRJFwMofoY0IXQGczMRAAVFSA7EhkNiMhbwIAA/sN+bH1CpgAAAAASUVORK5CYII=",
                     icon.toRaw());
    }

    @Test
    public void testLocalFileGif()
    {
        FileIcon icon = new FileIcon(getTestDataFile("smile.gif"));
        assertEquals("data:image/gif;base64,R0lGODlhCAAIAPEAAPz+BPz+/AAAAAAAACH5BAkKAAIAIf8LTkVUU0NBUEUyLjADAQAAACwAAAAACAAIAAACEZSAYJfIElREIdaGs3PPNFMAACH5BAkKAAIALAAAAAAIAAgAAAIRlIBgl8gSVEQh1oazU4szJxQAIfkECTIAAgAsAAAAAAgACAAAAhKUgGCXyBJURCHWhlU7fCmzCQUAIfkECRQAAgAsAAAAAAgACAAAAhGUgGCXyBIaClFa1Y5eymRRAAAh+QQJMgACACwAAAAACAAIAAACEpSAYJfIElREIdaGVTt8KbMJBQA7",
                     icon.toRaw());
    }

    @Test
    public void testLocalFilePng()
    {
        FileIcon icon = new FileIcon(getTestDataFile("info.png"));
        assertEquals("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAICAYAAADED76LAAAAL0lEQVQYlWN0NPv3nwEPYIEx9p1kRJFwMofoY0IXQGczMRAAVFSA7EhkNiMhbwIAA/sN+bH1CpgAAAAASUVORK5CYII=",
                     icon.toRaw());
    }
}
