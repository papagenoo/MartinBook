package martinbook.ch33.modem.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 18:17
 * To change this template use File | Settings | File Templates.
 */
public interface ModemImplementation {

    public void dial();
    public void hangup();
    public void send();
    public void receive();

}
