package GUI;

import Backend.Main;
import BoardGeneration.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame
{
    private final int titleBarSize;
    private GridLayout layout;

    private BoardPanel boardPanel;
    private OptionsPanel optionsPanel;

    public Frame()
    {
        this(4, 4);
    }
    public Frame(int rows, int columns)
    {
        this.setSize(720, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Word Hunt");

        layout = new GridLayout(1, 2);
        this.setLayout(layout);
        boardPanel = new BoardPanel(new Board(rows, columns), this);
        optionsPanel = new OptionsPanel(this, boardPanel);

        this.add(boardPanel);
        this.add(optionsPanel);

        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");

        JMenuItem newBoard = new JMenuItem("New Board");
        newBoard.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                System.out.println("You clicked new board!");

                int rows, columns;
                try
                {
                    rows = Integer.parseInt(JOptionPane.showInputDialog("How many rows do you want?"));
                    columns = Integer.parseInt(JOptionPane.showInputDialog("How many columns do you want?"));
                    Main.init(rows, columns);
                }
                catch(NumberFormatException f)
                {
                    JOptionPane.showMessageDialog(null, "Invalid input, creating a 4x4 board.");
                    Main.init(4, 4);
                }
            }
        });

        JMenuItem showWords = new JMenuItem("Show Words");
        showWords.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // new frame with scrolling jlist with every word in boardPanel
                System.out.println("You clicked show words!");
            }
        });

        optionsMenu.add(newBoard);
        optionsMenu.add(showWords);
        menuBar.add(optionsMenu);
        this.setJMenuBar(menuBar);





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
