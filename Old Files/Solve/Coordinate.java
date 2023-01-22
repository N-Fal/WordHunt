package Solve;

public class Coordinate
{
    private int row, column;

    public Coordinate(int r, int c)
    {
        row = r;
        column = c;
    }

    public int getRow()
    {
        return row;
    }
    public int getColumn()
    {
        return column;
    }

    // distance formula between 2 points (pythagorean theorem)
    // integer math makes diagonal space count as the same distance as vertical or horizontal

    public boolean adjacentTo(Coordinate other)
    {
        return distanceTo(other) <= 1;
    }

    public int distanceTo(Coordinate other)
    {
        return (int)( Math.sqrt(Math.pow(Math.abs(this.getColumn() - other.getColumn()), 2) + Math.pow(Math.abs(this.getRow() - other.getRow()), 2)));
    }

    public String toString()
    {
        return "(" + row + ", " + column + ")";
    }
}
