package Testing;

import BoardGeneration.Board;
import Solving.WordHunter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputTester
{
    public static void main(String[] args)
    {
        Board b = new Board(new char[][]{{'D', 'S', 'R', 'G'}, {'M', 'E', 'N', 'U'}, {'O', 'T', 'A', 'T'}, {'I', 'X', 'S', 'I'}});

        // Board b = new Board(4, 4);
        WordHunter hunter = new WordHunter(b);
        System.out.println(b);

        Scanner dictionaryReader = null;
        try
        {
            dictionaryReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        } catch (FileNotFoundException e) {e.printStackTrace();}

        while (dictionaryReader.hasNext())
        {
            String word = dictionaryReader.nextLine();
            if (hunter.onBoard(word))
            {
                System.out.println(word);
            }
        }
    }
}
