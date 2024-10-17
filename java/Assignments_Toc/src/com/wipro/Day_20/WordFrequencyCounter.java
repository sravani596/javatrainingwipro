package com.wipro.Day_20;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordFrequencyCounter {

    public static void main(String[] args) {
        // Specify the input and output file paths
        String inputFilePath = "input.txt";  // Replace with your input file path
        String outputFilePath = "output.txt"; // Replace with your output file path

        // Read the file and count word frequencies
        Map<String, Integer> wordCountMap = countWordFrequencies(inputFilePath);

        // Write the results to the output file
        writeWordFrequenciesToFile(outputFilePath, wordCountMap);
    }

    // Method to count word frequencies from the input file
    private static Map<String, Integer> countWordFrequencies(String filePath) {
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+"); // Split the line into words based on whitespace
                for (String word : words) {
                    word = word.toLowerCase(); // Convert to lowercase for case-insensitive counting
                    word = word.replaceAll("[^a-zA-Z]", ""); // Remove any non-alphabetic characters
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return wordCountMap;
    }

    // Method to write word frequencies to the output file
    private static void writeWordFrequenciesToFile(String filePath, Map<String, Integer> wordCountMap) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Set<Map.Entry<String, Integer>> entries = wordCountMap.entrySet();
            for (Map.Entry<String, Integer> entry : entries) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
