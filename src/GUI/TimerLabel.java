package GUI;

import Backend.Stopwatch;

import javax.swing.*;
import java.awt.*;

public class TimerLabel extends JLabel
{
    private int seconds;
    private boolean paused = true;
    private Stopwatch timer;

    public TimerLabel()
    {
        timer = new Stopwatch();
        setText("00:00:00");

        Thread updateThread = new Thread(() ->
        {
            while (true)
            {
                if (timer.getElaspedTime(Stopwatch.Unit.DECISECONDS) > seconds * 10L)
                {
                    stop();
                    setForeground(Color.RED);
                }
                if (!paused)
                {
                    setForeground(Color.BLACK);
                    setText(timer.getTimeFormatted());
                }

                try
                {
                    Thread.sleep(10);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        updateThread.start();
    }

    public void stop()
    {
        paused = true;
    }

    public void start(int seconds)
    {
        timer = new Stopwatch();
        this.seconds = seconds;
        paused = false;
    }

    public String getTime()
    {
        return timer.getTimeFormatted();
    }
}
