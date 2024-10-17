package com.wipro.Day_6;
public class LinkedListMiddleElementSearch {

    // Node class representing each node in the linked list
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head node of the linked list
    Node head;

    // Function to add a new node to the linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Function to find the middle element of the linked list
    public void findMiddle() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        // Initialize two pointers
        Node slowPointer = head;
        Node fastPointer = head;

        // Traverse the list with the fast pointer moving two steps and the slow pointer moving one step
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // The slow pointer now points to the middle element
        System.out.println("The middle element is: " + slowPointer.data);
    }

    public static void main(String[] args) {
    	LinkedListMiddleElementSearch list = new LinkedListMiddleElementSearch();
        
        // Adding elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Finding and printing the middle element
        list.findMiddle();
    }
}
