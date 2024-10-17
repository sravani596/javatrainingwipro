package com.wipro.Day_11;
public class StringOperations {

    // Method to perform the string operations
    public static String processStrings(String str1, String str2, int substringLength) {
        // Concatenate the two strings
        String concatenated = str1 + str2;
        
        // Reverse the concatenated string
        String reversed = new StringBuilder(concatenated).reverse().toString();
        
        // Find the length of the reversed string
        int reversedLength = reversed.length();
        
        // Handle edge case where substring length is greater than the reversed string length
        if (substringLength > reversedLength) {
            System.out.println("Error: Substring length is greater than the length of the reversed string.");
            return "";
        }
        
        // Find the middle index
        int startIndex = (reversedLength - substringLength) / 2;
        
        // Extract the middle substring
        return reversed.substring(startIndex, startIndex + substringLength);
    }

    public static void main(String[] args) {
        // Example usage of the method
        String str1 = "Hello";
        String str2 = "World";
        int substringLength = 5;

        // Perform the operations
        String result = processStrings(str1, str2, substringLength);
        
        // Print the result
        System.out.println("Result: " + result);
    }
}
