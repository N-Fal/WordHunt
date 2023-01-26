// TEXTBASED: This branch will record the development of a text-based version of the final game, as a blueprint for the final game.
package Model;

import java.awt.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner kbReader = new Scanner(System.in);
        System.out.println("-------Word Hunt--------");
        System.out.println("-start             -exit");
        System.out.print("- ");

        switch(kbReader.nextLine().toUpperCase())
        {
            case "S":
            case "START":
                int numRows, numColumns;
                System.out.print("How many rows would you like in your board?\n-");
                numRows = kbReader.nextInt();
                System.out.print("How many columns would you like in your board?\n-");
                numColumns = kbReader.nextInt();

                Game game = new Game(numRows, numColumns);
                Stopwatch timer = new Stopwatch();
                kbReader.nextLine();

                String input;
                do
                {
                    System.out.println("type /help for a list of commands");
                    game.printBoard();
                    System.out.print("Guess - ");

                    input = kbReader.nextLine();
                    switch (input.toUpperCase())
                    {
                        case "/H":
                        case "/HELP":
                            System.out.println("/help: shows a list of commands");
                            System.out.println("/progress: shows how many words you've found");
                            System.out.println("/found: shows a list of the words you've found");
                            System.out.println("/time: shows how long you've been playing");
                            break;
                        case "/P":
                        case "/PROGRESS":
                            System.out.println("You've found " + game.getProportionFound() + " words.");
                            break;
                        case "/F":
                        case "/FOUND":
                            game.printFound();
                            break;
                        case "/T":
                        case "/TIME":
                            System.out.println("You've spent " + timer.getTimeFormatted() + ".");
                            break;
                        default:
                            game.guess(input);
                    }

                    System.out.println();
                }
                while (!(input.equalsIgnoreCase("/EXIT") || input.equalsIgnoreCase("/E")));

                break;

            case "E":
            case "EXIT":
                System.exit(0);
                break;
        }
    }
}
