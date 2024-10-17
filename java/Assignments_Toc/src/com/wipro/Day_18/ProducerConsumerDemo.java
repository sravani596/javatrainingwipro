package com.wipro.Day_18;
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDemo {

    // Shared buffer
    private static final Queue<Integer> buffer = new LinkedList<>();
    private static final int MAX_SIZE = 5;

    // Monitor object for synchronization
    private static final Object lock = new Object();

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer());
        Thread consumer = new Thread(new Consumer());

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            int item = 0;
            while (true) {
                synchronized (lock) {
                    // Wait if the buffer is full
                    while (buffer.size() == MAX_SIZE) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Produce an item and add it to the buffer
                    buffer.add(item++);
                    System.out.println("Produced: " + (item - 1));

                    // Notify the consumer that an item is available
                    lock.notify();

                    // Simulate time taken to produce an item
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // Wait if the buffer is empty
                    while (buffer.isEmpty()) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }

                    // Consume an item from the buffer
                    int item = buffer.poll();
                    System.out.println("Consumed: " + item);

                    // Notify the producer that space is available
                    lock.notify();

                    // Simulate time taken to consume an item
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }
}
