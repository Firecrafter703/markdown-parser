import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;


public class MarkdownParseTest {
    @Test
    public void addition() {
        //assertEquals(2, 1 + 1);
        //javac -cp ".;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar" MarkdownParseTest.java
        //java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore MarkdownParseTest    
    }
    
    @Test
    public void getLinksTest() throws IOException
    {
        List somethingList = List.of("https://something.com", "some-thing.html");
        MarkdownParse mP = new MarkdownParse();
        Path p = Path.of("test-file.md");
        String Content = Files.readString(p);
        ArrayList<String> output = mP.getLinks(Content);
        assertEquals(somethingList, output);

        
    }


    @Test
    public void getLinksTest2() throws IOException
    {
        List somethingList = List.of("https://www.nintendo.com");
        MarkdownParse mP = new MarkdownParse();
        Path p = Path.of("Test-file2.md");
        String Content = Files.readString(p);
        ArrayList<String> output = mP.getLinks(Content);
        assertEquals(somethingList, output);

        
    }


    @Test
    public void getLinksTest3() throws IOException
    {
        List somethingList = List.of("fef");
        MarkdownParse mP = new MarkdownParse();
        Path p = Path.of("test-file3.md");
        String Content = Files.readString(p);
        ArrayList<String> output = mP.getLinks(Content);
        assertEquals(somethingList, output);

        
    }
    
    /*
    public void getLinksTest4() throws IOException
    {
        List somethingList = List.of("fef");
        MarkdownParse mP = new MarkdownParse();
        Path p = Path.of("test-file4.md");
        String Content = Files.readString(p);
        ArrayList<String> output = mP.getLinks(Content);
        assertEquals(somethingList, output);

        
    }
    */
}