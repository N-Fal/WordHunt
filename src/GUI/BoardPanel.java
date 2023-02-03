package GUI;

import BoardGeneration.Board;
import BoardGeneration.WordHunter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class BoardPanel extends JPanel
{
    private final Frame parentFrame;
    private final LetterBox[][] boardGraphics;
    private int boxBorderSize = 20;
    private final BoardListener listener;

    private final Board board;
    private final HashSet<String> boardWords;
    private ArrayList<String> foundWords;


    public BoardPanel(Board b, Frame f)
    {
        this.setBorder(new LineBorder(Color.BLACK));
        parentFrame = f;
        board = b;
        boardGraphics = new LetterBox[board.getNumRows()][board.getNumColumns()];

        boardWords = new HashSet<>();
        this.populateWordSet();

        foundWords = new ArrayList<>();

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
        // testing code
        g.setColor(Color.ORANGE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);

        boxBorderSize = getWidth() / 18;

        int boxHeight = this.getHeight() / board.getNumRows();
        int boxWidth = this.getWidth() / board.getNumColumns();
        int boxSize = Math.min(boxHeight, boxWidth) - boxBorderSize;

        Dimension size = new Dimension(board.getNumColumns() * (boxSize + boxBorderSize), board.getNumRows() * (boxSize + boxBorderSize));
//        this.setSize(size);
//        this.setPreferredSize(size);
//        this.setMaximumSize(size);
//        this.setMinimumSize(size);

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

    public String getInputHTML()
    {
        return listener.getInputHTML();
    }

    public String getInput()
    {
        return listener.getInput();
    }

    private void populateWordSet()
    {
        WordHunter hunter = new WordHunter(board);
        Scanner dictReader = null;
        try
        {
            dictReader = new Scanner(getClass().getResourceAsStream("/Dictionary/dictionary.txt"));
        }
        catch (NullPointerException e)
        {
            System.out.println("Dictionary file not found.");
            System.exit(0);
        }

        while (dictReader.hasNext())
        {
            String word = dictReader.nextLine();
            if (hunter.onBoard(word))
            {
                boardWords.add(word);
                System.out.println(word);
            }
        }
    }

    public boolean boardHasWord(String word)
    {
        return boardWords.contains(word.toLowerCase());
    }

    public void wordFound(String word)
    {
        foundWords.add(word);
    }

    public boolean inList(String word)
    {
        return foundWords.contains(word.toLowerCase());
    }

    public ArrayList<String> getList()
    {
        return foundWords;
    }

    public int getNumWords()
    {
        return boardWords.size();
    }
}
