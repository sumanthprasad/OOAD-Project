package org.quizsystem.decorator;

public class HintFeature extends QuizDecorator {
    public HintFeature(QuizFeature quizFeature) {
        super(quizFeature);
    }

    @Override
    public void applyFeature() {
        super.applyFeature();
        System.out.println("Hints Enabled.");
    }
}
