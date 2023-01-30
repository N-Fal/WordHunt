package GUI;

import java.awt.*;

public class LetterBox
{
    private final char letter;
    private boolean chosen;
    private int posX, posY, sideLength;

    public LetterBox(char letter)
    {
        this.letter = letter;
        chosen = false;
    }

    public void drawSelf(int x, int y, int s, Graphics g)
    {
        posX = x;
        posY = y;
        sideLength = s;

        g.drawRect(x, y, sideLength, sideLength);
        g.setColor((chosen) ? Color.GREEN : Color.WHITE);
        g.fillRect(x + 1, y + 1, sideLength - 1 ,sideLength - 1);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Inconsolata", Font.BOLD, sideLength));

        switch(letter)
        {
            case 'I':
                g.drawString("" + letter, x + sideLength / 3, y + 7 * g.getFontMetrics().getHeight() / 10);
                break;
            case 'W':
                g.drawString("" + letter, x + sideLength / 20, y + 7 * g.getFontMetrics().getHeight() / 10);
                break;
            default:
                g.drawString("" + letter, x + sideLength / 7, y + 7 * g.getFontMetrics().getHeight() / 10);

        }
    }

    public boolean inBounds(int x, int y)
    {
        return (x > posX && x < posX + sideLength && y > posY && y < posY + sideLength);
    }

    public void setChosen(boolean b)
    {
        chosen = b;
    }

    public boolean isChosen()
    {
        return chosen;
    }

    public char getLetter()
    {
        return letter;
    }

    @Override
    public String toString()
    {
        return "X: " + posX + " Y: " + posY + "S: " + sideLength;
    }
}
