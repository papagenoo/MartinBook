package martinbook.ch33.classAdapter;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 15:42
 * To change this template use File | Settings | File Templates.
 */
public class LightAdapter extends Light implements Switchable {

    @Override
    public void turnOn() {
        on();
    }

    @Override
    public void turnOff() {
        off();
    }
}
