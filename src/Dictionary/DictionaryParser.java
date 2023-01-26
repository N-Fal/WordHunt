package Dictionary;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DictionaryParser
{
    public static void main(String[] args) throws IOException
    {
        Scanner dictReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        FileWriter newDictWriter = new FileWriter("src/Dictionary/dictionaryNew.txt");

        while(dictReader.hasNext())
        {
            String word = dictReader.nextLine();
            if (word.length() >= 3)
            {
                newDictWriter.write(word + "\n");
            }
        }
        newDictWriter.close();
    }
}
