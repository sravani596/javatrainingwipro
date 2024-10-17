package com.wipro.Day_6;
public class CircularQueueBinarySearch {

    // Function to perform binary search on a rotated sorted circular queue
    public static int circularBinarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;  // Calculate mid point

            // Check if the middle element is the target
            if (arr[mid] == target) {
                return mid;
            }

            // Determine which part is sorted
            if (arr[low] <= arr[mid]) {  // Left half is sorted
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;  // Target is in the left half
                } else {
                    low = mid + 1;   // Target is in the right half
                }
            } else {  // Right half is sorted
                if (target > arr[mid] && target <= arr[high]) {
                    low = mid + 1;   // Target is in the right half
                } else {
                    high = mid - 1;  // Target is in the left half
                }
            }
        }

        // If the element is not found, return -1
        return -1;
    }

    public static void main(String[] args) {
        // Circular queue (rotated sorted array)
        int[] circularQueue = {12, 14, 18, 21, 3, 6, 8, 9};

        // Element to search for
        int target = 6;

        // Perform the search
        int result = circularBinarySearch(circularQueue, target);

        if (result != -1) {
            System.out.println("Element " + target + " found at index " + result);
        } else {
            System.out.println("Element " + target + " not found in the circular queue.");
        }
    }
}
