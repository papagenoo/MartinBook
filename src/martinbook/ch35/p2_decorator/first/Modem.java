package martinbook.ch35.p2_decorator.first;

/**
 * Created by max on 12/04/14.
 */
public interface Modem {
    void dial(String pno);
    int getSpeakerVolume();
    void setSpeakerVolume(int v);
    String getPhoneNumber();
}
