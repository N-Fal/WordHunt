package Backend;

public class Stopwatch
{
    private long startTime;

    public Stopwatch()
    {
        this.restart();
    }

    public void restart()
    {
        startTime = System.nanoTime();
    }

    public long getElaspedTime(Unit unit)
    {
        return (long)((System.nanoTime() - startTime) / unit.factor);
    }

    public String getTimeFormatted()
    {
        long mins = getElaspedTime(Unit.MINUTES), secs = getElaspedTime(Unit.SECONDS) % 60, decs = getElaspedTime(Unit.DECISECONDS) % 10;

        return ((mins < 10) ? "0" + mins : mins) + ":" + ((secs < 10) ? "0" + secs : secs) + ":0" + decs;
    }

    public String timeReport(Unit highest)
    {
        if(highest.equals(Unit.PICOSECONDS))
        {
            return "";
        }
        else return getElaspedTime(highest)  + " " + highest.name() + "\n" + timeReport(Unit.values()[highest.ordinal() + 1]);
    }

    @Override
    public String toString()
    {
        return getTimeFormatted();
    }

    // divide the time by (factor)
    public enum Unit
    {
        HOURS(3.6e12),
        MINUTES(6e10),
        SECONDS(1e9),
        DECISECONDS(1e8),
        CENTISECONDS(1e7),
        MILLISECONDS(1e6),
        MICROSECONDS(1e3),
        NANOSECONDS(1),
        PICOSECONDS(1e-3);

        private double factor;

        Unit(double factor)
        {
            this.factor = factor;
        }
    }

    // testing
    @Deprecated
    private String timeModulo(Unit lowest)
    {
        if (lowest.equals(Unit.HOURS))
        {
            return getElaspedTime(lowest) + " " + lowest.name();
        }

        else return  timeModulo(Unit.values()[lowest.ordinal() - 1]) + "\n" + (long)(getElaspedTime(lowest) % (Unit.values()[lowest.ordinal() - 1].factor / lowest.factor)) + " " + lowest.name();
    }
}