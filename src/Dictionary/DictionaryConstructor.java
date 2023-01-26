package Dictionary;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// this class isn't a part of the final project, it's temporary and was used to generate the dictonary text file
// previously used dictionary: https://raw.githubusercontent.com/dwyl/english-words/master/words.txt
// must filter out non-letter characters, capitals, and < 3 length words

public class DictionaryConstructor
{
    public static void main(String[] args) throws IOException
    {
        URL url = new URL("https://www.wordgamedictionary.com/enable/download/enable.txt");
        Scanner siteReader = new Scanner(url.openStream());
        FileWriter writer = new FileWriter("dictionary.txt");

        while (siteReader.hasNext())
        {
            String temp = siteReader.nextLine();

            // filtering words that are too short from the final list.
            if (temp.length() >= 3)
            {
                writer.write(temp);
                writer.write("\n");
            }
        }
        writer.close();
    }

    private boolean hasNonLetter(String s)
    {
        for (char c : s.toCharArray())
        {
            if(!Character.isLetter(c))
            {
                return false;
            }
        }
        return true;
    }

    private boolean hasUpperCase(String s)
    {
        for (char c : s.toCharArray())
        {
            if (c >= 65 && c <= 90)
            {
                return true;
            }
        }
        return false;
    }
}