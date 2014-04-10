package martinbook.ch33.modem.ideal;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 10.04.14
 * Time: 16:27
 * To change this template use File | Settings | File Templates.
 */
public class SomeModemClient {

    private final Modem modem;
    private final Dialler dialler;

    public SomeModemClient(Modem modem, Dialler dialler) {
        this.modem = modem;
        this.dialler = dialler;
    }

}
