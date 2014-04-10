package martinbook.observer;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:16
 * To change this template use File | Settings | File Templates.
 */
public class MockTimeSink implements Observer {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;
    private TimeSource itsSource;

    public MockTimeSink(TimeSource source) {
        itsSource = source;
    }

    public int getHours() {
        return itsHours;
    }

    public int getMinutes()
    {
        return itsMinutes;
    }

    public int getSeconds()
    {
        return itsSeconds;
    }

    @Override
    public void update() {
        itsHours = itsSource.getHours();
        itsMinutes = itsSource.getMinutes();
        itsSeconds = itsSource.getSeconds();
    }
}
