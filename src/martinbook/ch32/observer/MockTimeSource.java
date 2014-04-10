package martinbook.ch32.observer;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:10
 * To change this template use File | Settings | File Templates.
 */
public class MockTimeSource extends Subject implements TimeSource {
    private int itsHours;
    private int itsMinutes;
    private int itsSeconds;

    public void setTime(int hours, int mins, int secs) {
        itsHours = hours;
        itsMinutes = mins;
        itsSeconds = secs;
        notifyObservers();
    }

    @Override
    public int getHours() {
        return itsHours;
    }

    @Override
    public int getMinutes() {
        return itsMinutes;
    }

    @Override
    public int getSeconds() {
        return itsSeconds;
    }
}
