package com.wipro.Day_12;
public class UniqueElementsFinder {

    // Method to find the two unique elements
    public static int[] findUniqueElements(int[] arr) {
        // Step 1: XOR all elements
        int xorAll = 0;
        for (int num : arr) {
            xorAll ^= num;
        }

        // Step 2: Find a bit that is set in xorAll (any bit that is 1)
        int setBit = xorAll & -xorAll; // The rightmost set bit

        // Step 3: Partition elements into two groups based on the set bit
        int unique1 = 0, unique2 = 0;
        for (int num : arr) {
            if ((num & setBit) == 0) {
                unique1 ^= num; // XOR elements where the bit is not set
            } else {
                unique2 ^= num; // XOR elements where the bit is set
            }
        }

        // Return the two unique elements
        return new int[] {unique1, unique2};
    }

    public static void main(String[] args) {
        // Example array with two unique elements
        int[] arr = {1, 2, 1, 3, 2, 5};

        // Find the unique elements
        int[] uniqueElements = findUniqueElements(arr);
        
        // Print the unique elements
        System.out.println("Unique elements are: " + uniqueElements[0] + " and " + uniqueElements[1]);
    }
}
