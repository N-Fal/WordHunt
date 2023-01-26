package BoardGeneration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class WordHunter
{

    private Board board;
    private boolean[][] visited;

    public WordHunter(Board b)
    {
        board = b;
        resetVisited();
    }

    public HashSet<String> getWordSet()
    {
        HashSet<String> output = new HashSet<String>();

        Scanner dictionaryReader = null;
        try
        {
            dictionaryReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        } catch (FileNotFoundException e)
        {
            System.out.println("Dictionary file not found, please check your directory and try again.");
            System.exit(0);
        }

        while (dictionaryReader.hasNext())
        {
            String word = dictionaryReader.nextLine();
            if (this.onBoard(word))
            {
                output.add(word);
            }
        }

//        for (String s : output)
//        {
//            System.out.println(s);
//        }
        return output;
    }

    public boolean onBoard(String word)
    {
        word = word.toUpperCase();

        for (int row = 0; row < board.getNumRows(); row++)
        {
            for (int column = 0; column < board.getNumColumns(); column++)
            {
                resetVisited();
                if (board.letterAt(row, column) == word.charAt(0))
                {
                    if (recursiveMethod(new Coordinate(row, column), word, 0))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean recursiveMethod(Coordinate location, String word, int letter)
    {
        letter++;
        visited[location.getRow()][ location.getColumn()] = true;

        for(Coordinate coordinate : board.getSurrounding(location))
        {
            if (board.letterAt(coordinate.getRow(), coordinate.getColumn()) == word.charAt(letter) && !visited[coordinate.getRow()][coordinate.getColumn()])
            {
                if (letter == word.length() - 1)
                {
                    return true;
                }
                else if (recursiveMethod(coordinate, word, letter))
                {
                    return true;
                }
            }
        }
        visited[location.getRow()][ location.getColumn()] = false;
        return false;
    }

    private void resetVisited()
    {
        visited = new boolean[board.getNumRows()][board.getNumColumns()];
    }

    public void printVisited()
    {
        for (boolean[] row : visited)
        {
            for (boolean column : row)
            {
                System.out.println(column ? "T " : "F ");
            }
            System.out.println();
        }
    }
}
