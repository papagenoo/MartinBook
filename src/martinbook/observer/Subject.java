package martinbook.observer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by max on 10/04/14.
 */
public class Subject {
    private ArrayList<Observer> itsObservers = new ArrayList<Observer>();

    public void notifyObservers()
    {
        for (Observer observer : itsObservers)
            observer.update();
    }

    public void registerObserver(Observer observer)
    {
        itsObservers.add(observer);
    }

}
