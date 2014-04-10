package martinbook.ch33.modem.bridge;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public abstract class ModemConnectionController implements Modem, DedicatedModem {

    // todo: Разобраться

    private ModemImplementation modemImp;

    public ModemConnectionController(ModemImplementation modemImp) {
        this.modemImp = modemImp;
    }

    protected void dialImp() {
        modemImp.dial();
    }

    protected void hangImp() {
        modemImp.hangup();
    }

    protected void sendImp() {
        modemImp.send();
    }

    protected void recieveImp() {
        modemImp.receive();
    }
}
