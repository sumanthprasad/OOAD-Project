package org.quizsystem.strategy;

public class MediumScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(int correctAnswers, int totalQuestions) {
        // Array summation as a moderate complexity operation
        int[] scores = new int[totalQuestions];
        for (int i = 0; i < correctAnswers; i++) {
            scores[i] = 1;
        }
        int sum = 0;
        for (int score : scores) {
            sum += score;
        }
        return sum;
    }
}
