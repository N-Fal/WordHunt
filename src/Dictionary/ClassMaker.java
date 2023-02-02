package Dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ClassMaker
{
    public static void main(String[] args) throws IOException
    {
        Scanner dictReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        FileWriter writer = new FileWriter("src/Dictionary/Dictionary.java");
        writer.write("public static final ArrayList<String> DICTIONARY = Dictionary.init();");
        writer.write("\n\nprivate static void init()");
        writer.write("\n{");

        while(dictReader.hasNext())
        {
            writer.write("\n\tDICTIONARY.add(" + dictReader.nextLine().toUpperCase() + ");");
        }

        writer.write("\n}");
        writer.close();
    }
}
