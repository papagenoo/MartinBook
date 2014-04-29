package martinbook.ch36.state.fowler;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 24.04.14
 * Time: 16:06
 * To change this template use File | Settings | File Templates.
 */
public class StateMachine {
    private State start;

    public StateMachine(State start) {
        this.start = start;
    }

    public Collection<State> getStates() {
        List<State> result = new ArrayList<State>();
        collectStates(result, start);
        return result;
    }

    private void collectStates(Collection<State> result, State s) {
        if (result.contains(s)) return;
        result.add(s);
        for (State next : s.getAllTargets())
            collectStates(result, next);
    }

    private List<Event> resetEvents = new ArrayList<Event>();

    public void addResetEvents(Event... events) {
        for (Event e : events) resetEvents.add(e);
    }

    public boolean isResetEvent(String eventCode) {
        return resetEventCodes().contains(eventCode);
    }

    private List<String> resetEventCodes() {
        List<String> result = new ArrayList<String>();
        for (Event e : resetEvents) result.add(e.getCode());
        return result;
    }
}
