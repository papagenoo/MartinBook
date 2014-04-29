package martinbook.ch36.state.fowler;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 24.04.14
 * Time: 16:23
 * To change this template use File | Settings | File Templates.
 */
public class Controller {
    private State currentState;
    private StateMachine machine;

    public CommandChannel getCommandChannel() {
        return commandsChannel;
    }

    private CommandChannel commandsChannel;

    public void handle(String eventCode) {
        if (currentState.hasTransition(eventCode))
            transitionTo(currentState.targetState(eventCode));

        else if (machine.isResetEvent(eventCode))
            transitionTo(machine.getStart());
        // ignore unknown events

    }

    private void transitionTo(State target) {
        currentState = target;
        currentState.executeActions(commandsChannel);

    }
}
