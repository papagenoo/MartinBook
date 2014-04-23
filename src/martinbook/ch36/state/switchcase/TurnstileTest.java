package martinbook.ch36.state.switchcase;

import org.junit.*;
import martinbook.ch36.state.switchcase.Turnstile.*;

/**
 * Created with IntelliJ IDEA.
 * User: Max Boytsov
 * Date: 23.04.14
 * Time: 18:35
 * To change this template use File | Settings | File Templates.
 */
public class TurnstileTest {
    private Turnstile turnstile;
    private TurnstileControllerSpoof controllerSpoof;

    private class TurnstileControllerSpoof implements TurnstileController {
        public boolean lockCalled = false;
        public boolean unlockCalled = false;
        public boolean thankyouCalled = false;
        public boolean alarmCalled = false;

        public void Lock() {
            lockCalled = true;
        }

        public void Unlock() {
            unlockCalled = true;
        }

        public void Thankyou() {
            thankyouCalled = true;
        }

        public void Alarm() {
            alarmCalled = true;
        }
    }

    @Before
    public void setUp() {
        controllerSpoof = new TurnstileControllerSpoof();
        turnstile = new Turnstile(controllerSpoof);
    }

    @Test
    public void InitialConditions() {
        Assert.assertEquals(State.LOCKED, turnstile.state);
    }

    @Test
    public void CoinInLockedState() {
        turnstile.state = State.LOCKED;
        turnstile.HandleEvent(Event.COIN);
        Assert.assertEquals(State.UNLOCKED, turnstile.state);
        Assert.assertTrue(controllerSpoof.unlockCalled);
    }

    @Test
    public void CoinInUnlockedState() {
        turnstile.state = State.UNLOCKED;
        turnstile.HandleEvent(Event.COIN);
        Assert.assertEquals(State.UNLOCKED, turnstile.state);
        Assert.assertTrue(controllerSpoof.thankyouCalled);
    }

    @Test
    public void PassInLockedState() {
        turnstile.state = State.LOCKED;
        turnstile.HandleEvent(Event.PASS);
        Assert.assertEquals(State.LOCKED, turnstile.state);
        Assert.assertTrue(controllerSpoof.alarmCalled);
    }

    @Test
    public void PassInUnlockedState() {
        turnstile.state = State.UNLOCKED;
        turnstile.HandleEvent(Event.PASS);
        Assert.assertEquals(State.LOCKED, turnstile.state);
        Assert.assertTrue(controllerSpoof.lockCalled);
    }
}