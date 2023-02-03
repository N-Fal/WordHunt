package Backend;// WORKING VERSION - This is the only branch that should be receiving pushes at the moment.

import BoardGeneration.Board;
import GUI.Frame;

public class Main
{
    private static Frame frame;

    public static void main(String[] args)
    {
        try
        {
            frame = new Frame(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        catch(NumberFormatException | IndexOutOfBoundsException e)
        {
            frame = new Frame();
        }
    }

    public static void init(int rows, int columns)
    {
        frame.dispose();
        frame = new Frame(rows, columns);
    }
}
