package Background;

import java.util.ArrayList;

// pointless as of right now
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
