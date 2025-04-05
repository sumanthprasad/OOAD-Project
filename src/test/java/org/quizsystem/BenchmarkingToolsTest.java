package org.quizsystem;// BenchmarkingToolsTest.java
import org.junit.jupiter.api.Test;
import org.quizsystem.core.BenchmarkingTools;

import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BenchmarkingToolsTest {

    @Test
    void testMeasureExecutionTime() {
        BenchmarkingTools.measureExecutionTime(() -> {
            int sum = 0;
            for (int i = 0; i < 1000; i++) {
                sum += i;
            }
        }, "TestTask");
    }

    @Test
    void testMeasureMemoryUsage() {
        BenchmarkingTools.measureMemoryUsage(() -> {
            int[] array = new int[1000];
            for (int i = 0; i < array.length; i++) {
                array[i] = i;
            }
        }, "TestMemoryTask");
    }


    @Test
    void testMeasurePeakMemoryUsage() {
        // Create a simple task that allocates memory
        Runnable task = () -> {
            int[] largeArray = new int[10_000_000]; // Allocate a large array
            for (int i = 0; i < largeArray.length; i++) {
                largeArray[i] = i;
            }
        };

        // Capture the output (optional, for manual validation)
        BenchmarkingTools.measurePeakMemoryUsage(task, "Memory Test Task");

        // Assert that the task completes successfully without exceptions
        assertDoesNotThrow(() -> BenchmarkingTools.measurePeakMemoryUsage(task, "Memory Test Task"));
    }

    @Test
    void testWarmUpJVM() {
        // Create a simple task to simulate JVM warming
        AtomicInteger counter = new AtomicInteger(0);
        Runnable task = counter::incrementAndGet;

        // Call the warmUpJVM method with multiple iterations
        BenchmarkingTools.warmUpJVM(task, 5);

        // Verify the task ran the correct number of times
        assertEquals(5, counter.get(), "The task should run 5 times during JVM warm-up.");
    }
}