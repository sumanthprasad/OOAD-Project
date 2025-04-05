
package org.quizsystem.strategy;

// Context
public class QuizScoring {
    private ScoringStrategy strategy;

    public void setStrategy(ScoringStrategy strategy) {
        this.strategy = strategy;
    }

    public int calculateScore(int correctAnswers, int totalQuestions) {
        return strategy.calculateScore(correctAnswers, totalQuestions);
    }
}
