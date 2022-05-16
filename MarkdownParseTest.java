import static org.junit.Assert.*;

import java.nio.file.*;
import java.util.*;

import org.junit.*;

public class MarkdownParseTest {

    @Test
    public void testFile1() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        String[] expected = {"https://something.com", "some-thing.html"};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testFile2() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md")));
        String[] expected = {"https://something.com", "some-page.html"};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testFile3() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md")));
        String[] expected = {""};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testFile5() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file5.md")));
        String[] expected = {};

        assertArrayEquals(expected, links.toArray());
    }

    @Test
    public void testFile6() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-file6.md")));
        String[] expected = {};

        assertArrayEquals(expected, links.toArray());
    }    

    @Test
    public void testPaddingMultiline() throws Exception {
        ArrayList<String> links = MarkdownParse.getLinks(Files.readString(Path.of("test-breaking-padding-multiline.md")));
        String[] expected = {"https://something.co.uk"};

        assertArrayEquals(expected, links.toArray());
    }
}