package com.wipro.Day_13n14;
import java.util.*;

// Define Job class
class Job {
    int id;
    int deadline;
    int profit;

    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class JobSequencingProblem {

    // Function to perform Job Sequencing with maximum profit using Greedy approach
    public static List<Job> JobSequencing(List<Job> jobs) {
        // Sort jobs based on profit in descending order
        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find maximum deadline to determine the size of the result array
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // Array to store result (jobs scheduled)
        Job[] result = new Job[maxDeadline];

        // Boolean array to track used slots in result array
        boolean[] slot = new boolean[maxDeadline];

        // Initialize all slots to be free
        Arrays.fill(slot, false);

        // Iterate through all jobs and find a slot for each job
        for (Job job : jobs) {
            // Find a slot for this job, starting from the last possible slot
            for (int j = Math.min(maxDeadline, job.deadline) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job;
                    slot[j] = true;
                    break;
                }
            }
        }

        // Create a list to store the result jobs
        List<Job> resultJobs = new ArrayList<>();
        for (Job job : result) {
            if (job != null) {
                resultJobs.add(job);
            }
        }

        return resultJobs;
    }

    // Main method to test the JobSequencing function
    public static void main(String[] args) {
        // Example usage:
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job(1, 4, 20));
        jobs.add(new Job(2, 1, 10));
        jobs.add(new Job(3, 1, 40));
        jobs.add(new Job(4, 1, 30));

        List<Job> result = JobSequencing(jobs);

        // Print the result
        System.out.println("Maximum profit sequence of jobs:");
        for (Job job : result) {
            System.out.println("Job ID: " + job.id + ", Deadline: " + job.deadline + ", Profit: " + job.profit);
        }
    }
}
