package martinbook.ch36.state.switchcase;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 23.04.14
 * Time: 18:33
 * To change this template use File | Settings | File Templates.
 */
public interface TurnstileController {
    void Lock();
    void Unlock();
    void Thankyou();
    void Alarm();
}
