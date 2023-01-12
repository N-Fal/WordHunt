package Dictionary;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class DictionaryConstructor
{
    public DictionaryConstructor() throws IOException
    {
        URL url = new URL("https://raw.githubusercontent.com/dwyl/english-words/master/words.txt");
        Scanner siteReader = new Scanner(url.openStream());
        FileWriter writer = new FileWriter("dictionary.txt");

        while (siteReader.hasNext())
        {
            String temp = siteReader.nextLine();

            if (hasNonLetter(temp) && !hasUpperCase(temp) && temp.length() >= 3)
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