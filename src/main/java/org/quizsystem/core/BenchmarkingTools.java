package org.quizsystem.core;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

public class BenchmarkingTools {

    public static void measureExecutionTime(Runnable task, String taskName) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        System.out.println(taskName + " execution time: " + (endTime - startTime) + " ns");
    }

    public static void measureMemoryUsage(Runnable task, String taskName) {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Suggest garbage collection before measurement
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        task.run();

        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();
        System.out.println(taskName + " memory usage: " + (memoryAfter - memoryBefore) + " bytes");
    }

    public static void measurePeakMemoryUsage(Runnable task, String taskName) {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();

        // Capture memory usage before the task
        long beforeUsedHeap = memoryBean.getHeapMemoryUsage().getUsed();

        // Run the task
        task.run();

        // Capture memory usage after the task
        long afterUsedHeap = memoryBean.getHeapMemoryUsage().getUsed();

        // Calculate peak memory usage
        System.out.println(taskName + " peak memory usage: " + (afterUsedHeap - beforeUsedHeap) + " bytes");
    }

    public static void warmUpJVM(Runnable task, int iterations) {
        System.out.println("Warming up JVM...");
        for (int i = 0; i < iterations; i++) {
            task.run();
        }
        System.out.println("JVM warm-up complete.");
    }
}