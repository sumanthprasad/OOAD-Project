package org.quizsystem.core;

import org.quizsystem.observer.QuizNotifier;
import org.quizsystem.observer.User;
import org.quizsystem.singleton.QuestionBank;
import org.quizsystem.strategy.EasyScoringStrategy;
import org.quizsystem.strategy.HardScoringStrategy;
import org.quizsystem.strategy.MediumScoringStrategy;
import org.quizsystem.strategy.QuizScoring;

public class QuizSystemDemo {
    public static void main(String[] args) {
        // JVM Warm-Up
        BenchmarkingTools.warmUpJVM(() -> {
            QuizNotifier notifier = new QuizNotifier();
            notifier.registerObserver(new User("Warm-Up User"));
            notifier.setMessage("Warm-Up Message");
            QuizScoring scoring = new QuizScoring();
            scoring.setStrategy(new EasyScoringStrategy());
            scoring.calculateScore(5, 10);
        }, 100);

        // Benchmark Singleton: Lazy vs Eager Initialization
        BenchmarkingTools.measureExecutionTime(() -> {
            QuestionBank lazy = QuestionBank.getLazyInstance();
            System.out.println("Lazy Singleton Initialized: " + lazy.getInitializationType());
        }, "Lazy Singleton Initialization");

        BenchmarkingTools.measureMemoryUsage(() -> {
            QuestionBank lazy = QuestionBank.getLazyInstance();
        }, "Lazy Singleton Memory Usage");

        BenchmarkingTools.measurePeakMemoryUsage(() -> {
            QuestionBank lazy = QuestionBank.getLazyInstance();
        }, "Lazy Singleton Peak Memory Usage");

        BenchmarkingTools.measureExecutionTime(() -> {
            QuestionBank eager = QuestionBank.getEagerInstance();
            System.out.println("Eager Singleton Initialized: " + eager.getInitializationType());
        }, "Eager Singleton Initialization");

        BenchmarkingTools.measureMemoryUsage(() -> {
            QuestionBank eager = QuestionBank.getEagerInstance();
        }, "Eager Singleton Memory Usage");

        BenchmarkingTools.measurePeakMemoryUsage(() -> {
            QuestionBank eager = QuestionBank.getEagerInstance();
        }, "Eager Singleton Peak Memory Usage");

        // Benchmark Observer with varying numbers of observers
        int[] observerCounts = {1, 10, 100, 1000, 10000};
        for (int count : observerCounts) {
            BenchmarkingTools.measureExecutionTime(() -> {
                QuizNotifier notifier = new QuizNotifier();
                for (int i = 0; i < count; i++) {
                    notifier.registerObserver(new User("User" + i));
                }
                notifier.setMessage("Observer Test with " + count + " observers");
            }, "Observer Pattern with " + count + " observers - Execution Time");

            BenchmarkingTools.measureMemoryUsage(() -> {
                QuizNotifier notifier = new QuizNotifier();
                for (int i = 0; i < count; i++) {
                    notifier.registerObserver(new User("User" + i));
                }
                notifier.setMessage("Observer Test with " + count + " observers");
            }, "Observer Pattern with " + count + " observers - Memory Usage");

            BenchmarkingTools.measurePeakMemoryUsage(() -> {
                QuizNotifier notifier = new QuizNotifier();
                for (int i = 0; i < count; i++) {
                    notifier.registerObserver(new User("User" + i));
                }
                notifier.setMessage("Observer Test with " + count + " observers");
            }, "Observer Pattern with " + count + " observers - Peak Memory Usage");
        }

        // Benchmark Strategy with varying complexities
        QuizScoring scoring = new QuizScoring();

        scoring.setStrategy(new EasyScoringStrategy());
        BenchmarkingTools.measureExecutionTime(() -> {
            System.out.println("Easy Score: " + scoring.calculateScore(8, 10));
        }, "Easy Strategy Execution Time");

        BenchmarkingTools.measureMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Easy Strategy Memory Usage");

        BenchmarkingTools.measurePeakMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Easy Strategy Peak Memory Usage");

        scoring.setStrategy(new MediumScoringStrategy());
        BenchmarkingTools.measureExecutionTime(() -> {
            System.out.println("Medium Score: " + scoring.calculateScore(8, 10));
        }, "Medium Strategy Execution Time");

        BenchmarkingTools.measureMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Medium Strategy Memory Usage");

        BenchmarkingTools.measurePeakMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Medium Strategy Peak Memory Usage");

        scoring.setStrategy(new HardScoringStrategy());
        BenchmarkingTools.measureExecutionTime(() -> {
            System.out.println("Hard Score: " + scoring.calculateScore(8, 10));
        }, "Hard Strategy Execution Time");

        BenchmarkingTools.measureMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Hard Strategy Memory Usage");

        BenchmarkingTools.measurePeakMemoryUsage(() -> {
            scoring.calculateScore(8, 10);
        }, "Hard Strategy Peak Memory Usage");
    }
}