package com.wipro.Day_7n8;
public class BalancedBinaryTree {

    // Node class representing each node in the binary tree
    static class Node {
        int data;
        Node left, right;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    // Function to check if the binary tree is balanced
    public static boolean isBalanced(Node root) {
        return checkHeight(root) != -1;
    }

    // Helper function to calculate the height of the tree
    // Returns -1 if the tree is unbalanced
    private static int checkHeight(Node node) {
        if (node == null) {
            return 0;  // Base case: height of an empty tree is 0
        }

        // Recursively check the height of the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) {
            return -1;  // Tree is unbalanced
        }

        // Recursively check the height of the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) {
            return -1;  // Tree is unbalanced
        }

        // If the height difference is more than 1, return -1 (unbalanced)
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // Return the height of the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        // Creating a balanced binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);

        if (isBalanced(root)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }

        // Creating an unbalanced binary tree
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.left.left = new Node(4);

        if (isBalanced(root2)) {
            System.out.println("The tree is balanced.");
        } else {
            System.out.println("The tree is not balanced.");
        }
    }
}
