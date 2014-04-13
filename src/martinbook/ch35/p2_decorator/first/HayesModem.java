package martinbook.ch35.p2_decorator.first;

/**
 * Created by max on 13/04/14.
 */
public class HayesModem implements Modem {

    private int speakerVolume;
    private String phoneNumber;

    @Override
    public void dial(String pno) {
        // dialing...
    }

    @Override
    public int getSpeakerVolume() {
        return speakerVolume;
    }

    @Override
    public void setSpeakerVolume(int v) {
        this.speakerVolume = v;
    }

    @Override
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
