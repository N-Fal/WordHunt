import Dictionary.DictionaryConstructor;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Board b = new Board();
        System.out.println(b);

        System.out.println(b.letterAt(0, 0));
        System.out.println(b.letterAt(2, 2));
        System.out.println(b.letterAt(0, 3));
    }
}
