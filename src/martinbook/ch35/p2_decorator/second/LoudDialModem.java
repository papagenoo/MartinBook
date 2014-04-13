package martinbook.ch35.p2_decorator.second;

/**
 * Created by max on 13/04/14.
 */
public class LoudDialModem extends ModemDecorator {

    public LoudDialModem(Modem m) {
        super(m);
    }

    @Override
    public void dial(String pno) {
        Modem m = getModem();
        m.setSpeakerVolume(10);
        m.dial(pno);
    }
}
