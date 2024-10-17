package com.wipro.Day_7n8;
public class Trie {

    // Trie Node class representing each node in the Trie
    static class TrieNode {
        // Array to store references to child nodes (for each letter a-z)
        TrieNode[] children;
        // Boolean flag to indicate if a word ends at this node
        boolean isEndOfWord;

        // Constructor to initialize a TrieNode
        public TrieNode() {
            children = new TrieNode[26];  // Assuming only lowercase English letters a-z
            isEndOfWord = false;
        }
    }

    private TrieNode root;  // Root of the Trie

    // Constructor to initialize the Trie
    public Trie() {
        root = new TrieNode();
    }

    // Function to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            int index = currentChar - 'a';  // Get index of the character

            // If the corresponding child node doesn't exist, create it
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];  // Move to the next node
        }
        // Mark the end of the word
        node.isEndOfWord = true;
    }

    // Function to check if the given prefix is present in the Trie
    public boolean isPrefix(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char currentChar = prefix.charAt(i);
            int index = currentChar - 'a';  // Get index of the character

            // If the corresponding child node doesn't exist, the prefix is not found
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];  // Move to the next node
        }
        return true;  // If we reach here, the prefix exists in the Trie
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Insert some words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("banana");
        trie.insert("bat");
        trie.insert("ball");

        // Check for prefixes
        System.out.println("Is 'app' a prefix?: " + trie.isPrefix("app"));  // true
        System.out.println("Is 'ban' a prefix?: " + trie.isPrefix("ban"));  // true
        System.out.println("Is 'bat' a prefix?: " + trie.isPrefix("bat"));  // true
        System.out.println("Is 'ball' a prefix?: " + trie.isPrefix("ball"));  // true
        System.out.println("Is 'batt' a prefix?: " + trie.isPrefix("batt"));  // false
        System.out.println("Is 'cat' a prefix?: " + trie.isPrefix("cat"));  // false
    }
}
