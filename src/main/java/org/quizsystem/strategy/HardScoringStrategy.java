package org.quizsystem.strategy;

public class HardScoringStrategy implements ScoringStrategy {
    @Override
    public int calculateScore(int correctAnswers, int totalQuestions) {
        // Ensure dimensions are compatible for matrix multiplication
        int rows = correctAnswers;
        int cols = totalQuestions;
        int[][] matrixA = new int[rows][cols];
        int[][] matrixB = new int[cols][rows]; // Transpose to ensure valid multiplication
        int[][] result = new int[rows][rows];

        // Initialize matrices
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrixA[i][j] = 1;
                matrixB[j][i] = 1; // Transposed values
            }
        }

        // Matrix multiplication
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) { // Result dimensions match rows of A
                result[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }

        // Calculate final score as the sum of all elements in the result matrix
        int score = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                score += result[i][j];
            }
        }
        return score;
    }
}