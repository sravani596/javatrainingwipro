package com.wipro.Day_6;
import java.util.Stack;

public class StackSortInPlace {

    // Function to sort a stack using an additional temporary stack
    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        // Iterate through each element in the stack
        while (!stack.isEmpty()) {
            // Pop the top element from the original stack
            int curr = stack.pop();

            // Transfer elements from the temporary stack back to the original stack
            // until the correct position for the current element is found
            while (!tempStack.isEmpty() && tempStack.peek() > curr) {
                stack.push(tempStack.pop());
            }

            // Push the current element into the temporary stack
            tempStack.push(curr);
        }

        // Now, transfer the elements back to the original stack from the temporary stack
        // to maintain the original stack with sorted elements
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        // Create a stack and push some unsorted integers
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);

        // Sort the stack
        sortStack(stack);

        // Print the sorted stack
        System.out.println("Sorted Stack: " + stack);
    }
}
