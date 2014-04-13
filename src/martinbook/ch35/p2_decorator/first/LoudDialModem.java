package martinbook.ch35.p2_decorator.first;

/**
 * Created by max on 13/04/14.
 */
public class LoudDialModem implements Modem {

    private Modem itsModem;

    public LoudDialModem(Modem m) {
        itsModem = m;
    }

    @Override
    public void dial(String pno) {
        itsModem.setSpeakerVolume(10);
        itsModem.dial(pno);
    }

    @Override
    public int getSpeakerVolume() {
        return itsModem.getSpeakerVolume();
    }

    @Override
    public void setSpeakerVolume(int v) {
        itsModem.setSpeakerVolume(v);
    }

    @Override
    public String getPhoneNumber() {
        return itsModem.getPhoneNumber();
    }
}
