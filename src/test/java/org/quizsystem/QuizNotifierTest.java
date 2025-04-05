package org.quizsystem;// QuizNotifierTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.observer.QuizNotifier;
import org.quizsystem.observer.Observer;

import static org.junit.jupiter.api.Assertions.*;

class QuizNotifierTest {

    @Test
    void testNotifyObservers() {
        QuizNotifier notifier = new QuizNotifier();
        TestObserver observer = new TestObserver();
        notifier.registerObserver(observer);
        notifier.setMessage("Hello Observers!");
        assertEquals("Hello Observers!", observer.getLastMessage());
    }

    @Test
    void testRemoveObserver() {
        // Create a QuizNotifier instance
        QuizNotifier notifier = new QuizNotifier();

        // Create two observers
        TestObserver observer1 = new TestObserver();
        TestObserver observer2 = new TestObserver();

        // Register the observers
        notifier.registerObserver(observer1);
        notifier.registerObserver(observer2);

        // Ensure both observers are added
        notifier.setMessage("Initial Message");
        assertEquals("Initial Message", observer1.getLastMessage());
        assertEquals("Initial Message", observer2.getLastMessage());

        // Remove observer1
        notifier.removeObserver(observer1);

        // Reset observer1's last message to track new updates
        observer1.resetMessage();

        // Change the message
        notifier.setMessage("Updated Message");

        // Verify observer1 does not receive updates after removal
        assertNull(observer1.getLastMessage(), "Observer1 should not receive updates after removal");

        // Verify observer2 still receives updates
        assertEquals("Updated Message", observer2.getLastMessage(), "Observer2 should still receive updates");
    }


    private static class TestObserver implements Observer {
        private String lastMessage;

        @Override
        public void update(String message) {
            this.lastMessage = message;
        }

        public String getLastMessage() {
            return lastMessage;
        }

        public void resetMessage() {
            this.lastMessage = null;
        }
    }
}