package org.quizsystem.observer;

import java.util.ArrayList;
import java.util.List;

// Concrete Subject
public class QuizNotifier implements Subject {
    private List<Observer> observers;
    private String message;

    public QuizNotifier() {
        observers = new ArrayList<>();
    }

    public void setMessage(String message) {
        this.message = message;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}
