
package org.quizsystem.singleton;

// Singleton with lazy and eager initialization
public class QuestionBank {
    // Eager initialization
    private static final QuestionBank eagerInstance = new QuestionBank(true);
    
    // Lazy initialization
    private static QuestionBank lazyInstance;

    private boolean isEager; // To differentiate instance types

    private QuestionBank(boolean isEager) {
        this.isEager = isEager;
    }

    // Eager accessor
    public static QuestionBank getEagerInstance() {
        return eagerInstance;
    }

    // Lazy accessor with synchronization for thread safety
    public static synchronized QuestionBank getLazyInstance() {
        if (lazyInstance == null) {
            lazyInstance = new QuestionBank(false);
        }
        return lazyInstance;
    }

    public String getInitializationType() {
        return isEager ? "Eager" : "Lazy";
    }
}
