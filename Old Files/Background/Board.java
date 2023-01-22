package Background;

import java.awt.*;
import java.util.ArrayList;

public class Board
{
    private final char[][] board = new char[4][4];

    public Board()
    {
        String[] possibleLetters = new String[]  {
                "AAEEGN", "ABBJOO", "ACHOPS", "AFFKPS",
                "AOOTTW", "CIMOTU", "DEILRX", "DELRVY",
                "DISTTY", "EEGHNW", "EEINSU", "EHRTVW",
                "EIOSST", "ELRTTY", "HIMNQU", "HLNNRZ"
        }; // These are the letters on the dice from Boggle™. Using these to generate each board gives a higher word density and a better overall experience.

        // all possible points on the 4x4 board
        ArrayList<Point> possiblePoints = new ArrayList<>();
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                possiblePoints.add(new Point(i, j));
            }
        }

        // grab a random point from the list of possibilities, choose a random "face" from a random letter "die," then add it to the board
        for (int i = 0 ; i < 16; i++)
        {
            Point p = possiblePoints.get((int)(Math.random() * possiblePoints.size()));
            board[p.x][p.y] = possibleLetters[i].charAt((int)(Math.random() * 6));
            possiblePoints.remove(p);
        }
    }

    public String toString()
    {
        StringBuilder output = new StringBuilder();

        for (int x = 0; x < 4; x++)
        {
            for (int y = 0; y < 4; y++)
            {
                output.append(board[x][y]);
                output.append(" ");
            }
            output.append("\n");
        }

        return output.toString();
    }

    public char letterAt(int row, int col)
    {
        return board[row][col];
    }
}
