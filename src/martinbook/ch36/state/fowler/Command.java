package martinbook.ch36.state.fowler;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 24.04.14
 * Time: 16:02
 * To change this template use File | Settings | File Templates.
 */
public class Command extends AbstractEvent {
    public Command(String name, String code) {
        super(name, code);
    }
}
