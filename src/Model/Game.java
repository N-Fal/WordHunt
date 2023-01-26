package Model;

import BoardGeneration.Board;
import BoardGeneration.WordHunter;

import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.util.ArrayList;
import java.util.HashSet;

public class Game
{
    private final Board board;
    private final WordHunter hunter;
    private final HashSet<String> wordSet;

    private final ArrayList<String> wordsFound;

    public Game(Dimension dimension)
    {
        this(dimension.height, dimension.width);
    }

    public Game(int rows, int columns)
    {
        board = new Board(rows, columns);
        hunter = new WordHunter(board);
        wordSet = hunter.getWordSet();
        wordsFound = new ArrayList<>();
    }

    public void printBoard()
    {
        System.out.println(board);
    }

    public void guess(String word)
    {
        word = word.toLowerCase();

        if (wordsFound.contains(word))
        {
            System.out.println("You already found " + word + ".");
        }
        else if (wordSet.contains(word))
        {
            System.out.println(word + " is on the board!");
            wordsFound.add(word);
        }
        else
        {
            System.out.println(word + " is not on the board.");
        }
    }

    public String getProportionFound()
    {
        return wordsFound.size() + "/" + wordSet.size();
    }

    public void printFound()
    {
        for (int i = 0; i < wordsFound.size() - 1; i++)
        {
            System.out.print(wordsFound.get(i) + ", ");
        }
        System.out.println(wordsFound.get(wordsFound.size() - 1));
    }
}
