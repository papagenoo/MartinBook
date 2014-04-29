package martinbook.ch36.state.fowler;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 24.04.14
 * Time: 16:05
 * To change this template use File | Settings | File Templates.
 */
public class Transition {
    private final State source, target;
    private final Event trigger;

    public Transition(State source, Event trigger, State target) {
        this.source = source;
        this.target = target;
        this.trigger = trigger;
    }

    public State getSource() {
        return source;
    }

    public State getTarget() {
        return target;
    }

    public Event getTrigger() {
        return trigger;
    }

    public String getEventCode() {
        return trigger.getCode();
    }
}
