package martinbook.ch36.state.transitions;

import martinbook.ch36.state.transitions.TurnstileController;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 23.04.14
 * Time: 18:31
 * To change this template use File | Settings | File Templates.
 */
public class Turnstile {
    public enum State {LOCKED, UNLOCKED};
    public enum Event {COIN, PASS};

    // Должно быть закрытым
    public State state = State.LOCKED;
    private TurnstileController turnstileController;
    public Turnstile(TurnstileController action) {
        turnstileController = action;
    }


    public Turnstile(TurnstileController controller) {
        Action unlock = new Action(controller.Unlock);
        Action alarm = new Action(controller.Alarm);
        Action thankYou = new Action(controller.Thankyou);
        Action lockAction = new Action(controller.Lock);
        AddTransition(
                State.LOCKED, Event.COIN, State.UNLOCKED, unlock);
        AddTransition(
                State.LOCKED, Event.PASS, State.LOCKED, alarm);
        AddTransition(
                State.UNLOCKED, Event.COIN, State.UNLOCKED, thankYou);
        AddTransition(
                State.UNLOCKED, Event.PASS, State.LOCKED, lockAction);
    }


    public void HandleEvent(Event e)
    {
        switch (state) {
            case LOCKED:
                switch (e) {
                    case COIN:
                        state = State.UNLOCKED;
                        turnstileController.Unlock();
                        break;
                    case PASS:
                        turnstileController.Alarm();break;
                }
                break;
            case UNLOCKED:
                switch (e) {
                    case COIN:
                        turnstileController.Thankyou();
                        break;
                    case PASS:
                        state = State.LOCKED;
                        turnstileController.Lock();
                        break;
                }
                break;
        }
    }
}