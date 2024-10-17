package com.wipro.Day_19;
public class GenericSwapDemo {

    // Generic method to swap two elements in an array
    public static <T> void swap(T[] array, int index1, int index2) {
        if (index1 < 0 || index2 < 0 || index1 >= array.length || index2 >= array.length) {
            throw new IllegalArgumentException("Invalid index");
        }
        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        // Demonstrate swapping with Integer array
        Integer[] intArray = {1, 2, 3, 4, 5};
        System.out.println("Original Integer array: " + java.util.Arrays.toString(intArray));
        swap(intArray, 1, 3); // Swap elements at index 1 and 3
        System.out.println("Swapped Integer array: " + java.util.Arrays.toString(intArray));

        // Demonstrate swapping with String array
        String[] strArray = {"Apple", "Banana", "Cherry"};
        System.out.println("Original String array: " + java.util.Arrays.toString(strArray));
        swap(strArray, 0, 2); // Swap elements at index 0 and 2
        System.out.println("Swapped String array: " + java.util.Arrays.toString(strArray));

        // Demonstrate swapping with Double array
        Double[] dblArray = {1.1, 2.2, 3.3};
        System.out.println("Original Double array: " + java.util.Arrays.toString(dblArray));
        swap(dblArray, 1, 2); // Swap elements at index 1 and 2
        System.out.println("Swapped Double array: " + java.util.Arrays.toString(dblArray));
    }
}
