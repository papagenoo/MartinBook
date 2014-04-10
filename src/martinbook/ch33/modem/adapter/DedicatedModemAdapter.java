package martinbook.ch33.modem.adapter;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 17:30
 * To change this template use File | Settings | File Templates.
 */
public class DedicatedModemAdapter implements Modem {

    private boolean dialed = false;
    DedicatedModem dedicatedModem;

    public DedicatedModemAdapter(DedicatedModem modem) {
        dedicatedModem = modem;
    }

    @Override
    public void dial() {
        dialed = true;
    }

    @Override
    public void hangup() {
        dialed = false;
    }

    @Override
    public void send() {
      if (dialed)
          dedicatedModem.send();
    }

    @Override
    public void receive() {
      if (dialed)
          dedicatedModem.receive();
    }

}
