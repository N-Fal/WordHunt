package Testing;

import Solve.Coordinate;
import Solve.Solver;

public class Main
{
    public static void main(String[] args)
    {
        Board b = new Board();
        System.out.println(b);

        System.out.println();

        Solver.solve(b);
    }
}
