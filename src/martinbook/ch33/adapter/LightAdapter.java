package martinbook.ch33.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 15:44
 * To change this template use File | Settings | File Templates.
 */
public class LightAdapter implements Switchable {

    private final Light light;

    public LightAdapter(Light light) {
        this.light = light;
    }

    @Override
    public void turnOn() {
        light.on();
    }

    @Override
    public void turnOff() {
        light.off();
    }
}
