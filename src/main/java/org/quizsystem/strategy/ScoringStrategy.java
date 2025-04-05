package org.quizsystem.strategy;

// Strategy Interface
public interface ScoringStrategy {
    int calculateScore(int correctAnswers, int totalQuestions);
}
