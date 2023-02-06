package GUI;

import Backend.Main;
import BoardGeneration.Board;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Frame extends JFrame
{
    private final int titleBarSize;
    private final GridLayout layout;

    private final BoardPanel boardPanel;
    private final OptionsPanel optionsPanel;

    private JFrame wordFrame;

    public Frame()
    {
        this(4, 4);
    }
    public Frame(int rows, int columns)
    {
        this.setSize(720, 480);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Word Hunt");

        LetterBox iconBox = new LetterBox('W');
        BufferedImage icon = new BufferedImage(30, 30, BufferedImage.TYPE_INT_RGB);
        iconBox.drawSelf(1, 1, 27, icon.getGraphics());
        this.setIconImage(icon);

        layout = new GridLayout(1, 2);
        this.setLayout(layout);
        boardPanel = new BoardPanel(new Board(rows, columns), this);
        optionsPanel = new OptionsPanel(this, boardPanel);

        this.add(boardPanel);
        this.add(optionsPanel);

        wordFrame = new JFrame();

        JMenuBar menuBar = new JMenuBar();
        JMenu optionsMenu = new JMenu("Options");

        JMenuItem newBoard = new JMenuItem("New Board");
        newBoard.addActionListener(e ->
        {
            int rows1, columns1;
            wordFrame.dispose();
            try
            {
                rows1 = Integer.parseInt(JOptionPane.showInputDialog("How many rows do you want?"));
                columns1 = Integer.parseInt(JOptionPane.showInputDialog("How many columns do you want?"));
                Main.init(rows1, columns1);
            }
            catch(NumberFormatException f)
            {
                JOptionPane.showMessageDialog(null, "Invalid input, creating a 4x4 board.");
                Main.init(4, 4);
            }
        });

        JMenuItem showWords = new JMenuItem("Show Words");
        showWords.addActionListener(e ->
        {
            wordFrame.dispose();
            wordFrame = new JFrame("Word List");
            Dimension size = new Dimension(360, 480);
            wordFrame.setResizable(false);
            wordFrame.setSize(size);
            wordFrame.setMinimumSize(size);



            JList<String> wordList = new JList<>();
            wordList.setListData(boardPanel.getAllWords());
            wordList.setFont(new Font("Inconsolata", Font.PLAIN, 20));

            wordList.setSize(size);
            wordList.setMinimumSize(size);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportView(wordList);

            wordFrame.add(scrollPane);

            wordFrame.pack();
            wordFrame.setLocation(getX() + getWidth() / 2, getY());
            wordFrame.setVisible(true);
        });

        optionsMenu.add(newBoard);
        optionsMenu.add(showWords);
        menuBar.add(optionsMenu);
        this.setJMenuBar(menuBar);

        this.setFocusable(true);
        this.setVisible(true);

        titleBarSize = this.getInsets().top + menuBar.getHeight();
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
