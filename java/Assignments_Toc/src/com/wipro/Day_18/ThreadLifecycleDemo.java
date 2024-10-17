package com.wipro.Day_18;
public class ThreadLifecycleDemo {

    public static void main(String[] args) {
        // Create a new thread
        Thread thread = new Thread(new LifecycleRunnable());
        System.out.println("Thread state after creation: " + thread.getState()); // NEW

        // Start the thread
        thread.start();
        try {
            // Give the thread some time to transition to RUNNABLE state
            Thread.sleep(100);

            // Wait for the thread to finish
            thread.join(); // Ensures the main thread waits until the lifecycle thread terminates
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Thread state after completion: " + thread.getState()); // TERMINATED
    }

    static class LifecycleRunnable implements Runnable {
        @Override
        public void run() {
            try {
                // Demonstrate RUNNABLE state
                System.out.println("Thread state inside run() method: " + Thread.currentThread().getState()); // RUNNABLE
                
                // Demonstrate TIMED_WAITING state
                System.out.println("Thread going to sleep for 2 seconds...");
                Thread.sleep(2000);
                System.out.println("Thread woke up from sleep.");

                // Demonstrate WAITING state
                synchronized (this) {
                    System.out.println("Thread waiting on monitor...");
                    wait();
                }

                // This part won't be reached unless notify() is called from another thread
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Thread state before termination: " + Thread.currentThread().getState()); // TERMINATED
            }
        }
    }
}
