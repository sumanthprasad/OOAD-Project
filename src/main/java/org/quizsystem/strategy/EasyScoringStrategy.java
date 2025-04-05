package org.quizsystem.strategy;

// Concrete Strategies
public class EasyScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(int correctAnswers, int totalQuestions) {
        return correctAnswers; // Simple arithmetic
    }
}
