package GUI;

import BoardGeneration.Board;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class BoardListener
{
    private final BoardPanel parentPanel;
    private final LetterBox[][] boardGraphics;
    private final StringBuilder input;
    private boolean mouseHeld;

    public BoardListener(LetterBox[][] boardGraphics, BoardPanel panel )
    {
        parentPanel = panel;
        this.boardGraphics = boardGraphics;
        input = new StringBuilder();
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

                if (temp.inBounds(mouseX, mouseY) && !temp.isChosen())
                {
                    temp.setChosen(true);
                    parentPanel.repaint();
                    input.append(temp.getLetter());
                    System.out.println(row + "," + column);
                }
            }
        }
    }

    private final MouseMotionListener motionListener = new MouseMotionListener()
    {
        @Override
        public void mouseDragged(MouseEvent e)
        {
            check();
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
            check();
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

            System.out.println(input);
            input.setLength(0);
            parentPanel.repaint();
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
}
