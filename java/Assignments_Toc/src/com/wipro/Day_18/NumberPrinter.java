package com.wipro.Day_18;
public class NumberPrinter implements Runnable {

    private String threadName;

    // Constructor to set the thread name
    public NumberPrinter(String name) {
        this.threadName = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(threadName + " - " + i);
            try {
                // Sleep for 1 second
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(threadName + " interrupted.");
            }
        }
    }

    public static void main(String[] args) {
        // Create two threads
        Thread thread1 = new Thread(new NumberPrinter("Thread 1"));
        Thread thread2 = new Thread(new NumberPrinter("Thread 2"));

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
