package org.quizsystem;// QuestionBankSingletonTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.singleton.QuestionBank;

import static org.junit.jupiter.api.Assertions.*;

class QuestionBankSingletonTest {

    @Test
    void testLazySingleton() {
        QuestionBank lazy1 = QuestionBank.getLazyInstance();
        QuestionBank lazy2 = QuestionBank.getLazyInstance();
        assertSame(lazy1, lazy2, "Lazy Singleton instances should be the same");
    }

    @Test
    void testEagerSingleton() {
        QuestionBank eager1 = QuestionBank.getEagerInstance();
        QuestionBank eager2 = QuestionBank.getEagerInstance();
        assertSame(eager1, eager2, "Eager Singleton instances should be the same");
    }

    @Test
    void testGetInitializationTypeEager() {
        // Get the eager singleton instance
        QuestionBank eagerInstance = QuestionBank.getEagerInstance();
        // Verify the initialization type
        assertEquals("Eager", eagerInstance.getInitializationType(),
                "Expected initialization type to be 'Eager'");
    }

    @Test
    void testGetInitializationTypeLazy() {
        // Get the lazy singleton instance
        QuestionBank lazyInstance = QuestionBank.getLazyInstance();
        // Verify the initialization type
        assertEquals("Lazy", lazyInstance.getInitializationType(),
                "Expected initialization type to be 'Lazy'");
    }

}