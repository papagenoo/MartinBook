package martinbook.ch33.modem.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 18:20
 * To change this template use File | Settings | File Templates.
 */
public class DialModemController extends ModemConnectionController {

    public DialModemController(ModemImplementation modemImp) {
        super(modemImp);
    }

    @Override
    public void dial() {
        dialImp();
    }

    @Override
    public void hangup() {
        hangImp();
    }

    @Override
    public void send() {
        sendImp();
    }

    @Override
    public void receive() {
        recieveImp();
    }
}
