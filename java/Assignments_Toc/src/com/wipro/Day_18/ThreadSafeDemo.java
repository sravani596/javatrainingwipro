package com.wipro.Day_18;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Thread-safe Counter class
class Counter {
    private final AtomicInteger count = new AtomicInteger(0);

    // Increment the counter
    public void increment() {
        count.incrementAndGet();
    }

    // Decrement the counter
    public void decrement() {
        count.decrementAndGet();
    }

    // Get the current value of the counter
    public int getValue() {
        return count.get();
    }
}

// Immutable class to share data between threads
final class ImmutableData {
    private final String data;

    public ImmutableData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

public class ThreadSafeDemo {

    public static void main(String[] args) {
        // Create a thread-safe Counter instance
        Counter counter = new Counter();

        // Create an immutable object to share data between threads
        ImmutableData sharedData = new ImmutableData("Shared Immutable Data");

        // Create a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit tasks to increment and decrement the counter
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                counter.increment();
                System.out.println("Counter incremented to: " + counter.getValue());
            });

            executor.submit(() -> {
                counter.decrement();
                System.out.println("Counter decremented to: " + counter.getValue());
            });
        }

        // Submit tasks to demonstrate using immutable data
        executor.submit(() -> {
            System.out.println("Thread reading immutable data: " + sharedData.getData());
        });

        // Shutdown the executor and await termination
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
