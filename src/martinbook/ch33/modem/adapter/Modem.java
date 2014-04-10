package martinbook.ch33.modem.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 16:24
 * To change this template use File | Settings | File Templates.
 */
public interface Modem {

    public void dial();
    public void hangup();
    public void send();
    public void receive();

}
