package Testing;

import BoardGeneration.Board;
import Solving.WordHunter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheatTester
{
    public static void main(String[] args)
    {
        Board b = new Board(4, 4);
        WordHunter hunter = new WordHunter(b);
        System.out.println(b);

        Scanner dictionaryReader = null;
        try
        {
            dictionaryReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        } catch (FileNotFoundException e) {e.printStackTrace();}

        int sum = 0;
        while (dictionaryReader.hasNext())
        {
            String word = dictionaryReader.nextLine();
            if (hunter.onBoard(word))
            {
                System.out.println(word);
                sum++;
            }
        }
        System.out.println(sum);
    }
}

