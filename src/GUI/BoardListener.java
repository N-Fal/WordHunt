package GUI;

import BoardGeneration.Coordinate;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BoardListener
{
    private final BoardPanel parentPanel;
    private final LetterBox[][] boardGraphics;
    private final StringBuilder input;
    private Coordinate lastVisited;
    private boolean mouseHeld;

    public BoardListener(LetterBox[][] boardGraphics, BoardPanel panel)
    {
        parentPanel = panel;
        this.boardGraphics = boardGraphics;
        input = new StringBuilder(" ");
    }

    private void check()
    {
        int mouseX = MouseInfo.getPointerInfo().getLocation().x - parentPanel.getParentFrame().getX();
        int mouseY = MouseInfo.getPointerInfo().getLocation().y - parentPanel.getParentFrame().getY() - parentPanel.getParentFrame().getTitleBarSize();

        for (int row = 0; row < boardGraphics.length; row++)
        {
            for (int column = 0; column < boardGraphics[0].length; column++)
            {
                LetterBox temp = boardGraphics[row][column];

                if (input.length() == 0)
                {
                    lastVisited = new Coordinate(row, column);
                }

                if (temp.inBounds(mouseX, mouseY) && !temp.isChosen() && lastVisited.adjacentTo(new Coordinate(row, column)))
                {
                    temp.setChosen(true);
                    parentPanel.repaint();
                    input.append(temp.getLetter());
                    // System.out.println(row + "," + column);
                    lastVisited = new Coordinate(row, column);
                }
            }
        }

        if (input.length() == 0)
        {
            input.append(" ");
        }
    }

    private final MouseMotionListener motionListener = new MouseMotionListener()
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            check();
            parentPanel.getParentFrame().repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e)
        {

        }
    };

    private final MouseListener buttonListener = new MouseListener()
    {
        @Override
        public void mousePressed(MouseEvent e)
        {
            mouseHeld = true;
            input.setLength(0);
            check();
            parentPanel.getParentFrame().repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            mouseHeld = false;
            for (int row = 0; row < boardGraphics.length; row++)
            {
                for (int column = 0; column < boardGraphics[0].length; column++)
                {
                    boardGraphics[row][column].setChosen(false);
                }
            }

            if (parentPanel.boardHasWord(getInput()) && !parentPanel.inList(getInput()))
            {
                // System.out.println(parentPanel.boardHasWord(getInput()));
                // System.out.println(parentPanel.inList(getInput()));

                parentPanel.wordFound(getInput().toLowerCase());
                // System.out.println("added " + getInput() + " to the list of found words.");
            }

            parentPanel.getParentFrame().repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };

    public MouseMotionListener getMotion()
    {
        return motionListener;
    }

    public MouseListener getButton()
    {
        return buttonListener;
    }

    public String getInputHTML()
    {
        StringBuilder output = new StringBuilder();
        output.append("<html>");

        for (int i = 0; i < input.length(); i += 16)
        {
            output.append(input.substring(i, Math.min(i + 16, input.length())));
            output.append("<br/>");
        }

        output.append("</html>");
        return output.toString();
    }

    public String getInput()
    {
        return input.toString();
    }
}
