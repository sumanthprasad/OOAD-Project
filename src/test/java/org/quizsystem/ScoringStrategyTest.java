package org.quizsystem;// ScoringStrategyTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.strategy.EasyScoringStrategy;
import org.quizsystem.strategy.MediumScoringStrategy;
import org.quizsystem.strategy.HardScoringStrategy;

import static org.junit.jupiter.api.Assertions.*;


class ScoringStrategyTest {

    @Test
    void testEasyScoring() {
        EasyScoringStrategy strategy = new EasyScoringStrategy();
        assertEquals(5, strategy.calculateScore(5, 10));
    }

    @Test
    void testMediumScoring() {
        MediumScoringStrategy strategy = new MediumScoringStrategy();
        assertEquals(5, strategy.calculateScore(5, 10));
    }

    @Test
    void testHardScoring() {
        HardScoringStrategy strategy = new HardScoringStrategy();
        assertTrue(strategy.calculateScore(2, 3) > 0);
    }
}