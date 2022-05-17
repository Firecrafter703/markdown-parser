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
<<<<<<< HEAD
        
            System.out.println("openBracket" + openBracket);
            System.out.println("closeBracket" + closeBracket);
            System.out.println("openParen" + openParen);
            System.out.println("closeParen" + closeParen);
            System.out.println("markdownParse change");
            System.out.println("part2
            ");
            //this if and else statemetn checks to see if the open and close brackets
            //and paren exists
            if(openBracket == -1 || closeBracket == -1 ||openParen == -1|| closeParen == -1)
            {// ssh-add ~/.ssh/id_ed25519
                //ssh-keygen -t ed25519-sk -C "your_email@example.com"
                currentIndex = markdown.length();
                System.out.println("error");
                break;
=======

            // Malformed construct and trailing whitespace fix
            if (openBracket == -1 || closeBracket == -1 ||
                    openParen == -1 || closeParen == -1) {
                currentIndex++;
                continue;
>>>>>>> c9aad7a02fd2dd72667790982f6260c5137a7666
            }

            // Image reference fix
            if (openBracket > 0 && markdown.charAt(openBracket - 1) == '!') {
                currentIndex = closeParen + 1;
                continue;
            }

            // URL padding fix
            String url = markdown.substring(openParen + 1, closeParen);
            url = url.replaceAll("^ *", "");
            url = url.replaceAll(" *$", "");

            if (url.split("\\n").length > 1) {
                System.out.println(url.split("\\n").length);
                currentIndex = closeParen + 1;
                continue;
            }

            // Ordering and space between title/url (test-file5.md)
            if (closeBracket != openParen - 1) {
                currentIndex = closeParen + 1;
                continue;
            }
            toReturn.add(url);

            currentIndex = closeParen + 1;
            // System.out.println(currentIndex);
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