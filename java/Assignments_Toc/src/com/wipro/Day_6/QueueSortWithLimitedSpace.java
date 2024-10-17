package com.wipro.Day_6;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueSortWithLimitedSpace {

    // Function to sort the queue using one stack
    public static void sortQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Iterate through all elements of the queue
        while (!queue.isEmpty()) {
            // Get the front element of the queue
            int curr = queue.poll();

            // Maintain sorted order in the stack
            while (!stack.isEmpty() && stack.peek() > curr) {
                queue.add(stack.pop());  // Move elements from stack to queue until the correct position is found
            }

            // Push the current element into the stack
            stack.push(curr);
        }

        // Now the stack contains the sorted elements in reverse order, so we put them back into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());  // Add elements back to the queue
        }
    }

    public static void main(String[] args) {
        // Create a queue and add some unsorted integers
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(1);
        queue.add(4);
        queue.add(2);
        queue.add(5);

        System.out.println("Original Queue: " + queue);

        // Sort the queue
        sortQueue(queue);

        // Print the sorted queue
        System.out.println("Sorted Queue: " + queue);
    }
}
