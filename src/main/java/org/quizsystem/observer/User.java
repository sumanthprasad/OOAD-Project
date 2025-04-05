package org.quizsystem.observer;

// Concrete Observer
public class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        // Simulate processing
        String res="Notification for " + name + ": " + message;
    }
}
