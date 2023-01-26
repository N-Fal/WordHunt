package Solve;
import Testing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solver
{

    // returns a list of valid words in the given board
    // void isn't permanent, I'm not sure whaet I'll be returning yet
    public static void solve(Board b)
    {
        HashMap<Character, ArrayList<Coordinate>> solveMap = Solver.populateMap(b);

        Scanner dictReader = null;
        try
        {
            dictReader = new Scanner(new File("src/Dictionary/dictionary.txt"));
        } catch (FileNotFoundException e) {e.printStackTrace();}

        while(dictReader.hasNext())
        {
            // do something with each word to verify if it's possible in Board b
        }
    }

    private static HashMap<Character, ArrayList<Coordinate>> populateMap(Board b)
    {
        HashMap<Character, ArrayList<Coordinate>> output = new HashMap<>();

        for (int r = 0; r < 4; r++)
        {
            for (int c = 0; c < 4; c++)
            {
                // if there's no key for this letter yet...
                if (!output.containsKey(b.letterAt(r, c)))
                {
                    // add it
                    output.put(b.letterAt(r, c), new ArrayList<Coordinate>());
                }
                // add this set of coordinates to the key's value
                output.get(b.letterAt(r, c)).add(new Coordinate(r, c));
            }
        }

        printSolveMap(output);

        return output;
    }

    private static boolean[][] refreshVisitedArray()
    {
        boolean[][] output = new boolean[4][4];
        for (int i = 0; i < 4; i++)
        {
            Arrays.fill(output[i], true);
        }

        return output;
    }

    private static void printSolveMap(HashMap<Character, ArrayList<Coordinate>> map)
    {
        for (Character c : map.keySet())
        {
            System.out.println(c + ", " + map.get(c));
        }
    }
}
