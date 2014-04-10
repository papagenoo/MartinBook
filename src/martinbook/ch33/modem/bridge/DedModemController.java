package martinbook.ch33.modem.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class DedModemController extends ModemConnectionController {

    private boolean connected = false;

    public DedModemController(ModemImplementation modemImp) {
        super(modemImp);
    }

    @Override
    public void dial() {
        connected = true;
    }

    @Override
    public void hangup() {
        connected = false;
    }

    @Override
    public void send() {
        if (connected)
            sendImp();
    }

    @Override
    public void receive() {
        if (connected)
            recieveImp();
    }
}
