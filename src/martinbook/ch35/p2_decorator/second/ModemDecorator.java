package martinbook.ch35.p2_decorator.second;

/**
 * Created by max on 13/04/14.
 */
public abstract class ModemDecorator implements Modem {

    private final Modem modem;

    public ModemDecorator(Modem m) {
        modem = m;
    }

    @Override
    public void dial(String pno) {
        modem.dial(pno);
    }

    @Override
    public int getSpeakerVolume() {
        return modem.getSpeakerVolume();
    }

    @Override
    public void setSpeakerVolume(int v) {
        modem.setSpeakerVolume(v);
    }

    @Override
    public String getPhoneNumber() {
        return modem.getPhoneNumber();
    }

    protected Modem getModem() {
        return modem;
    }
}
