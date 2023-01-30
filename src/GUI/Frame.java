package GUI;

import BoardGeneration.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Frame extends JFrame
{
    private final int titleBarSize;
    private JPanel mainPanel;

    public Frame()
    {
        this.setSize(720, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Word Hunt");
        this.add(new BoardPanel(new Board(4, 4), this));
        this.setFocusable(true);
        this.setVisible(true);

        titleBarSize = this.getInsets().top;
    }

    public int getTitleBarSize()
    {
        return titleBarSize;
    }
}
