import java.util.ArrayList;

public class Game
{
    private Board b;
    private ArrayList<String> validWords = new ArrayList<String>();

    public Game()
    {
        this.shake();
    }

    public void shake()
    {
        b = new Board();

    }
}
