package chapter09.observer;

public interface Subject {

    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}
