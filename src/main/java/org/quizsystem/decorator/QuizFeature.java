
package org.quizsystem.decorator;

// Base Component
public interface QuizFeature {
    void applyFeature();
}

// Decorator
abstract class QuizDecorator implements QuizFeature {
    protected QuizFeature quizFeature;

    public QuizDecorator(QuizFeature quizFeature) {
        this.quizFeature = quizFeature;
    }

    @Override
    public void applyFeature() {
        quizFeature.applyFeature();
    }
}

