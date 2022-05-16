//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class MarkdownParse {
//~/.ssh/config
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link up to next )
        int currentIndex = 0;
        while (currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);

            // Malformed construct and trailing whitespace fix
            if (openBracket == -1 || closeBracket == -1 ||
                    openParen == -1 || closeParen == -1)
                break;

            // Image reference fix
            if (openBracket > 0 && markdown.charAt(openBracket - 1) == '!'){
                currentIndex = closeParen + 1;
                break;
            }

            // URL padding fix
            String url = markdown.substring(openParen + 1, closeParen);
            url = url.replaceAll("^ *", "");
            url = url.replaceAll(" *$", "");

            for(char c : url.toCharArray()) {
                if(c == '\n') {
                    currentIndex = closeParen + 1;
                    break;
                }
            }

            // Ordering and space between title/url (test-file5.md)
            if(closeBracket != openParen - 1) {
                currentIndex = closeParen + 1;
                break;
            }
            toReturn.add(url);

            currentIndex = closeParen + 1;
            System.out.println(currentIndex);
        }
        System.out.println(toReturn);
        return toReturn;
    }

    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
        System.out.println(links);
    }
}