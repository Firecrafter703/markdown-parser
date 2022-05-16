//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {
//~/.ssh/config
    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link up to next )
        int currentIndex = 0;
        int infLoop = 0;
        System.out.println("markdown length " + markdown.length());
        System.out.println("AAA");


        while(currentIndex < markdown.length()) 
        {
            
            int openBracket = markdown.indexOf("[", currentIndex);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
        
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
            {
                currentIndex = markdown.length();
                System.out.println("error");
                break;
            }
            
            else
            {
            toReturn.add(markdown.substring(openParen + 1, closeParen));
            currentIndex = closeParen + 1;
            System.out.println("curIndx" +currentIndex);
            }
            infLoop++;
             if(infLoop > 100)
                {
                    break;
                }
        }
        System.out.println(toReturn);
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
        System.out.println("SCREAMIN");
    }
}