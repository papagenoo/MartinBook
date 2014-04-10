package martinbook.ch32.observer;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 09.04.14
 * Time: 19:25
 * To change this template use File | Settings | File Templates.
 */
public interface TimeSource {

    int getHours();
    int getMinutes();
    int getSeconds();

}
