package Testing;

import Model.Stopwatch;
import java.util.Scanner;

public class TimerTester
{
    public static void main(String[] args) throws InterruptedException
    {
        Scanner kb = new Scanner(System.in);
        Stopwatch timer = new Stopwatch();
        System.out.println("The timer has started!\nEnter anything to see how much time has passed.\nEnter \"stop\" or \"s\" to end the program and get a formatted time.");

        String input;
        do
        {
            input = kb.nextLine();

            System.out.println(timer.timeReport(Stopwatch.Unit.PICOSECONDS));

        } while(!exitInput(input));
    }

    private static boolean exitInput(String s)
    {
        s = s.toUpperCase();
        return s.equals("S") || s.equals("STOP");
    }
}
