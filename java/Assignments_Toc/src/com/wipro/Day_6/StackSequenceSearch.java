package com.wipro.Day_6;
import java.util.Stack;

public class StackSequenceSearch {

    // Function to check if a sequence is present in the stack
    public static boolean isSequenceInStack(Stack<Integer> stack, int[] sequence) {
        // Temporary stack to hold popped elements so that we do not modify the original stack
        Stack<Integer> tempStack = new Stack<>();
        int seqIndex = sequence.length - 1; // Start checking from the end of the sequence

        // Iterate while the stack is not empty
        while (!stack.isEmpty()) {
            int top = stack.pop();  // Pop the top element of the stack
            tempStack.push(top);    // Push it to tempStack to preserve the original stack

            // If the top element matches the current element of the sequence
            if (top == sequence[seqIndex]) {
                seqIndex--;  // Move to the previous element in the sequence
            }

            // If we have matched the entire sequence
            if (seqIndex < 0) {
                break;  // Sequence is found
            }
        }

        // Restore the original stack from the tempStack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        // If seqIndex is -1, it means we matched all elements of the sequence
        return seqIndex < 0;
    }

    public static void main(String[] args) {
        // Create a stack and push some integers
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        stack.push(8);
        stack.push(9);

        // Define the sequence to search for
        int[] sequence = {6, 7, 8};

        // Check if the sequence is present in the stack
        boolean isPresent = isSequenceInStack(stack, sequence);

        // Print the result
        System.out.println("Is the sequence present in the stack? " + isPresent);
    }
}
