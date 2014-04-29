package martinbook.ch36.state.fowler;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 24.04.14
 * Time: 16:01
 * To change this template use File | Settings | File Templates.
 */
public class AbstractEvent {
    private String name, code;

    public AbstractEvent(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
