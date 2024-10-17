package com.wipro.Day_7n8;
import java.util.ArrayList;

public class MinHeap {
    private ArrayList<Integer> heap;

    // Constructor to initialize the heap
    public MinHeap() {
        heap = new ArrayList<>();
    }

    // Function to insert a new element into the heap
    public void insert(int value) {
        // Add the new value at the end of the heap
        heap.add(value);
        // "Bubble up" to maintain the heap property
        bubbleUp(heap.size() - 1);
    }

    // Function to delete the minimum element (root) from the heap
    public int deleteMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }

        // Store the root (minimum) element to return it later
        int minValue = heap.get(0);

        // Move the last element to the root and remove the last element
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        // "Bubble down" to maintain the heap property
        bubbleDown(0);

        return minValue; // Return the minimum element
    }

    // Function to get the minimum element without removing it
    public int getMin() {
        if (heap.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0); // The root is the minimum element
    }

    // Helper function to restore heap property by "bubbling up"
    private void bubbleUp(int index) {
        // Get the parent index
        int parentIndex = (index - 1) / 2;

        // Bubble up until the heap property is restored
        while (index > 0 && heap.get(index) < heap.get(parentIndex)) {
            // Swap the current element with its parent
            swap(index, parentIndex);

            // Move to the parent index
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    // Helper function to restore heap property by "bubbling down"
    private void bubbleDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        // Find the smallest element among the current node and its children
        if (leftChild < heap.size() && heap.get(leftChild) < heap.get(smallest)) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && heap.get(rightChild) < heap.get(smallest)) {
            smallest = rightChild;
        }

        // If the current node is not the smallest, swap it with the smallest child
        if (smallest != index) {
            swap(index, smallest);
            bubbleDown(smallest); // Recursively bubble down the swapped child
        }
    }

    // Utility function to swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }

    // Main method to demonstrate heap operations
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert elements into the heap
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(30);
        minHeap.insert(2);
        minHeap.insert(8);

        // Get the minimum element
        System.out.println("Minimum element: " + minHeap.getMin()); // Output: 2

        // Delete the minimum element
        System.out.println("Deleted minimum element: " + minHeap.deleteMin()); // Output: 2

        // Get the new minimum element
        System.out.println("New minimum element: " + minHeap.getMin()); // Output: 5

        // Insert more elements
        minHeap.insert(1);
        System.out.println("Minimum element after insertion: " + minHeap.getMin()); // Output: 1
    }
}
