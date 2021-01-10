package chapter09.observer;

import java.util.ArrayList;
import java.util.List;

public class Feed implements Subject{
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(observer -> observer.inform(tweet));
    }
}
