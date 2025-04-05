package org.quizsystem;// QuizScoringTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.strategy.QuizScoring;
import org.quizsystem.strategy.EasyScoringStrategy;
import org.quizsystem.strategy.MediumScoringStrategy;
import org.quizsystem.strategy.HardScoringStrategy;

import static org.junit.jupiter.api.Assertions.*;

class QuizScoringTest {

    @Test
    void testSetStrategyAndCalculateScore() {
        QuizScoring scoring = new QuizScoring();

        scoring.setStrategy(new EasyScoringStrategy());
        assertEquals(5, scoring.calculateScore(5, 10));

        scoring.setStrategy(new MediumScoringStrategy());
        assertEquals(5, scoring.calculateScore(5, 10));

        scoring.setStrategy(new HardScoringStrategy());
        assertTrue(scoring.calculateScore(2, 3) > 0);
    }
}