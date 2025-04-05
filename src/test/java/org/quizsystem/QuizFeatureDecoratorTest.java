package org.quizsystem;// QuizFeatureDecoratorTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.decorator.BasicQuiz;
import org.quizsystem.decorator.HintFeature;
import org.quizsystem.decorator.QuizFeature;
import org.quizsystem.decorator.TimerFeature;

class QuizFeatureDecoratorTest {

    @Test
    void testBasicQuiz() {
        QuizFeature basicQuiz = new BasicQuiz();
        basicQuiz.applyFeature(); // Expect "Basic Quiz Started." in console
    }

    @Test
    void testQuizWithTimer() {
        QuizFeature basicQuiz = new BasicQuiz();
        QuizFeature timedQuiz = new TimerFeature(basicQuiz);

        timedQuiz.applyFeature(); // Expect "Basic Quiz Started." followed by "Timer Enabled."
    }

    @Test
    void testQuizWithHint() {
        QuizFeature basicQuiz = new BasicQuiz();
        QuizFeature hintedQuiz = new HintFeature(basicQuiz);

        hintedQuiz.applyFeature(); // Expect "Basic Quiz Started." followed by "Hints Enabled."
    }

    @Test
    void testQuizWithMultipleFeatures() {
        QuizFeature basicQuiz = new BasicQuiz();
        QuizFeature quizWithFeatures = new TimerFeature(new HintFeature(basicQuiz));

        quizWithFeatures.applyFeature();
        // Expect "Basic Quiz Started." followed by "Hints Enabled." and "Timer Enabled."
    }
}