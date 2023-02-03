package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

public class OptionsPanel extends JPanel
{
    private final Frame parentFrame;
    private final BoardPanel boardPanel;
    private final BorderLayout layout;
    private final JLabel inputLabel, numFoundLabel;

    private final JList<String> wordList;

    public OptionsPanel(Frame parent, BoardPanel bp)
    {
        this.setBackground(new Color(28, 185, 176));
        this.setBorder(new LineBorder(Color.BLACK));

        parentFrame = parent;
        boardPanel = bp;

        layout = new BorderLayout();
        layout.setHgap(20);
        layout.setVgap(20);
        this.setLayout(layout);


        inputLabel = new JLabel();
        // inputLabel.setBorder(new LineBorder(Color.BLACK));
        inputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        inputLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(inputLabel, BorderLayout.PAGE_START);

        numFoundLabel = new JLabel();
        // numFoundLabel.setBorder(new LineBorder(Color.BLACK));
        numFoundLabel.setHorizontalAlignment(SwingConstants.CENTER);
        numFoundLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(numFoundLabel, BorderLayout.PAGE_END);

        wordList = new JList<>();
        wordList.setBorder(new LineBorder(Color.BLACK));
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(wordList);
        wordList.setLayoutOrientation(JList.VERTICAL);

        this.add(scrollPane, BorderLayout.CENTER);


        this.add(Box.createRigidArea(new Dimension()), BorderLayout.LINE_START);
        this.add(Box.createRigidArea(new Dimension()), BorderLayout.LINE_END);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(Color.BLACK);

        if (boardPanel.inList(boardPanel.getInput()))
        {
            inputLabel.setForeground(Color.YELLOW);
        }
        else if (boardPanel.boardHasWord(boardPanel.getInput()))
        {
            inputLabel.setForeground(Color.GREEN);
            // System.out.println("Word on board");
        }
        else
        {
            inputLabel.setForeground(Color.BLACK);
        }

        inputLabel.setText(boardPanel.getInput());
        inputLabel.setFont(new Font("Inconsolata", Font.BOLD, Math.min(getWidth(), getHeight()) / 11));

        numFoundLabel.setText(boardPanel.getList().size() + " / " + boardPanel.getNumWords());
        inputLabel.setFont(new Font("Inconsolata", Font.BOLD, Math.min(getWidth(), getHeight()) / 11));

        String[] words = boardPanel.getList().toArray(new String[0]);
        Arrays.sort(words);
        wordList.setFont(new Font("Inconsolata", Font.PLAIN, Math.min(getWidth(), getHeight()) / 22));
        wordList.setListData(words);
        wordList.repaint();
    }

    public Frame getParentFrame()
    {
        return parentFrame;
    }

    public BoardPanel getBoardPanel()
    {
        return boardPanel;
    }
}
