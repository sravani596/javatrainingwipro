package com.wipro.Day_18;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeNumberDemo {

    public static void main(String[] args) {
        // Define the upper limit for prime number calculation
        int upperLimit = 10000;
        
        // Create a fixed-size thread pool
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // Submit the prime number calculation task
        Future<List<Integer>> primeFuture = executor.submit(() -> calculatePrimes(upperLimit));
        
        // Use CompletableFuture to handle asynchronous file writing
        CompletableFuture.supplyAsync(() -> {
            try {
                // Get the result of the prime calculation
                List<Integer> primes = primeFuture.get();
                // Write the results to a file
                writePrimesToFile(primes, "primes.txt");
                return "Prime numbers written to file successfully!";
            } catch (Exception e) {
                throw new RuntimeException("Error writing primes to file", e);
            }
        }, executor).thenAccept(result -> {
            System.out.println(result);
            executor.shutdown();
        }).exceptionally(ex -> {
            System.err.println(ex.getMessage());
            executor.shutdown();
            return null;
        });
    }

    // Method to calculate prime numbers up to a given limit
    private static List<Integer> calculatePrimes(int limit) {
        List<Integer> primes = new ArrayList<>();
        for (int num = 2; num <= limit; num++) {
            if (isPrime(num)) {
                primes.add(num);
            }
        }
        return primes;
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    // Method to write a list of prime numbers to a file
    private static void writePrimesToFile(List<Integer> primes, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int prime : primes) {
                writer.write(prime + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }
    }
}
