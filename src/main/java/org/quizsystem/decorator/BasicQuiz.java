package org.quizsystem.decorator;

// Concrete Component
public class BasicQuiz implements QuizFeature {
    @Override
    public void applyFeature() {
        System.out.println("Basic Quiz Started.");
    }
}
