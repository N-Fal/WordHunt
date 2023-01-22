package BoardGeneration;

import java.util.ArrayList;

public class Board
{
    private char[][] board;
    private int numRows, numColumns;

    public Board(int numRows, int numColumns)
    {
        Generator g = new Generator();
        this.numRows = numRows;
        this.numColumns = numColumns;
        board = new char[numRows][numColumns];

        for (int row = 0; row < numRows; row++)
            for (int column = 0; column < numColumns; column++)
                board[row][column] = g.generateLetter();
    }

    public char letterAt(int row, int column)
    {
        return board[row][column];
    }

    public ArrayList<Coordinate> getSurrounding(Coordinate coordinate)
    {
        ArrayList<Coordinate> output = new ArrayList<Coordinate>();

        for (int row = 0; row < numRows; row++)
        {
            for (int column = 0; column < numColumns; column++)
            {
                Coordinate temp = new Coordinate(row, column);
                if(coordinate.adjacentTo(temp))
                {
                    output.add(temp);
                }
            }
        }

        return output;
    }

    public int getNumRows()
    {
        return numRows;
    }

    public int getNumColumns()
    {
        return numColumns;
    }

    @Override
    public String toString()
    {
        StringBuilder output = new StringBuilder();

        for (char[] row : board)
        {
            for (char column : row)
            {
                output.append(column);
                output.append(" ");
            }
            output.append("\n");
        }

        return output.toString();
    }
}
