package com.concurrency;

	// Importing necessary classes for multithreading
	class MyTask extends Thread {
	    private String taskName;

	    // Constructor to initialize task with a name
	    public MyTask(String taskName) {
	        this.taskName = taskName;
	    }

	    // Override the run method to define the task the thread will execute
	    @Override
	    public void run() {
	        for (int i = 1; i <= 5; i++) {
	            System.out.println(taskName + " - Count: " + i);
	            try {
	                // Simulate some delay in each iteration to see thread interleaving
	                Thread.sleep(500); // 500 milliseconds
	            } catch (InterruptedException e) {
	                e.printStackTrace(); // Handle any interruption during sleep
	            }
	        }
	        System.out.println(taskName + " has completed.");
	    }
	}

	public class ConcurrencyThreadAssignment {
	    public static void main(String[] args) {
	        // Creating two tasks (threads)
	        MyTask task1 = new MyTask("Task 1");
	        MyTask task2 = new MyTask("Task 2");

	        // Start both threads
	        task1.start();
	        task2.start();

	        // Main thread will wait until both threads are finished
	        try {
	            task1.join(); // Wait for task1 to finish
	            task2.join(); // Wait for task2 to finish
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }

	        System.out.println("Both tasks have finished execution.");
	    }
	}

