package GUI;

import BoardGeneration.Board;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame
{
    private final int titleBarSize;
    private GridLayout layout;

    private BoardPanel boardPanel;
    private OptionsPanel optionsPanel;

    public Frame()
    {
        this.setSize(720, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Word Hunt");

        layout = new GridLayout(1, 2);
        this.setLayout(layout);
        boardPanel = new BoardPanel(new Board(4, 4), this);
        optionsPanel = new OptionsPanel(this, boardPanel);

        this.add(boardPanel);
        this.add(optionsPanel);



        this.setFocusable(true);
        this.setVisible(true);

        titleBarSize = this.getInsets().top;
    }

    public int getTitleBarSize()
    {
        return titleBarSize;
    }

    public OptionsPanel getOptionsPanel()
    {
        return optionsPanel;
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);

        if (getWidth() > getHeight())
        {
            layout.setRows(1);
            layout.setColumns(2);
        }
        else
        {
            layout.setRows(2);
            layout.setColumns(1);
        }

        // ALMOST makes everything perfect but breaks it instead
        // this.pack();
    }
}
