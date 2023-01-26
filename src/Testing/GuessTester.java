package Testing;

import BoardGeneration.Board;
import Solving.WordHunter;

import java.util.Scanner;

public class GuessTester
{
    public static void main(String[] args)
    {
        Board b = new Board(4, 4);
        WordHunter hunter = new WordHunter(b);

        Scanner kb = new Scanner(System.in);
        String word = "";
        do
        {
            System.out.println(b);
            System.out.print("Enter a String: ");

            word = kb.nextLine();
            System.out.println(hunter.onBoard(word) ? word + " is present on the board." : word + " is not present on the board.");
        } while (!word.equals("."));
    }
}
