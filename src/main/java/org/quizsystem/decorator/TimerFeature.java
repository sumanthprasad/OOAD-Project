package org.quizsystem.decorator;

// Concrete Decorators
public class TimerFeature extends QuizDecorator {
    public TimerFeature(QuizFeature quizFeature) {
        super(quizFeature);
    }

    @Override
    public void applyFeature() {
        super.applyFeature();
        System.out.println("Timer Enabled.");
    }
}
