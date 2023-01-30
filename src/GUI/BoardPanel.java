package GUI;

import BoardGeneration.Board;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel
{
    private final Frame parentFrame;
    private final LetterBox[][] boardGraphics;
    private final int boxBorderSize = 20;
    private Board board;
    private BoardListener listener;

    public BoardPanel(Board b, Frame f)
    {
        parentFrame = f;
        board = b;
        boardGraphics = new LetterBox[board.getNumRows()][board.getNumColumns()];

        listener = new BoardListener(boardGraphics, this);
        this.addMouseMotionListener(listener.getMotion());
        this.addMouseListener(listener.getButton());
        this.setFocusable(true);

        for (int row = 0; row < board.getNumRows(); row++)
        {
            for (int column = 0; column < board.getNumColumns(); column++)
            {
                boardGraphics[row][column] = new LetterBox(board.letterAt(row, column));
            }
        }
    }

    @Override
    public void paint(Graphics g)
    {
        int boxHeight = this.getHeight() / board.getNumRows();
        int boxWidth = this.getWidth() / board.getNumColumns();
        int boxSize = Math.min(boxHeight, boxWidth) - boxBorderSize;

        int penX = boxBorderSize / 2, penY = boxBorderSize / 2;
        for (int row = 0; row < board.getNumRows(); row++)
        {
            for (int column = 0; column < board.getNumColumns(); column++)
            {
                boardGraphics[row][column].drawSelf(penX, penY, boxSize, g);
                penX += boxSize + boxBorderSize;
            }
            penY += boxSize + boxBorderSize;
            penX = boxBorderSize / 2;
        }
    }

    public Frame getParentFrame()
    {
        return parentFrame;
    }
}
