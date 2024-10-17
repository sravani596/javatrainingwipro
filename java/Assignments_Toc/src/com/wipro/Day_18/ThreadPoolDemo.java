package com.wipro.Day_18;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        // Create a fixed-size thread pool with 4 threads
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        // Submit multiple tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            threadPool.submit(new Task("Task " + i));
        }

        // Shutdown the thread pool
        threadPool.shutdown();
        
        try {
            // Wait for all tasks to complete
            if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    // Task class that performs a complex calculation or I/O operation
    static class Task implements Runnable {
        private String taskName;

        public Task(String taskName) {
            this.taskName = taskName;
        }

        @Override
        public void run() {
            System.out.println(taskName + " started by " + Thread.currentThread().getName());
            try {
                // Simulate complex calculation or I/O operation
                int result = performComplexCalculation();
                System.out.println(taskName + " result: " + result);
                Thread.sleep(2000); // Simulate time-consuming task
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(taskName + " completed by " + Thread.currentThread().getName());
        }

        // Simulate a complex calculation
        private int performComplexCalculation() {
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
            }
            return sum;
        }
    }
}
