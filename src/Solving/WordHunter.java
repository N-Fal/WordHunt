package Solving;

import BoardGeneration.Board;
import BoardGeneration.Coordinate;

public class WordHunter
{

    private Board board;
    private boolean[][] visited;

    public WordHunter(Board b)
    {
        board = b;
        resetVisited();
    }

    public boolean onBoard(String word)
    {
        word = word.toUpperCase();
        boolean output = false;

        firstLetterSearch:
        for (int row = 0; row < board.getNumRows(); row++)
        {
            for (int column = 0; column < board.getNumColumns(); column++)
            {
                resetVisited();
                if (board.letterAt(row, column) == word.charAt(0))
                {
                    output = recursiveMethod(new Coordinate(row, column), word, 0);
                    break firstLetterSearch;
                }
            }
        }
        return output;
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
                else
                {
                    return recursiveMethod(coordinate, word, letter);
                }
            }
        }
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
                if (column)
                {
                    System.out.print("T ");
                }
                else
                {
                    System.out.print("F ");
                }
            }
            System.out.println();
        }
    }
}
