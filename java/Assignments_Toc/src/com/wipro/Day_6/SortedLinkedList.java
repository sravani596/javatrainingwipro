package com.wipro.Day_6;
public class SortedLinkedList {

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

    // Function to add a new node to the end of the list
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

    // Function to remove duplicates from a sorted linked list
    public void removeDuplicates() {
        if (head == null) {
            return; // List is empty
        }

        Node current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            // Compare current node with the next node
            if (current.data == current.next.data) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next node if no duplicate
                current = current.next;
            }
        }
    }

    // Function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();
        
        // Adding elements to the list (some are duplicates)
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        list.add(4);
        list.add(5);

        System.out.println("Original List:");
        list.printList();

        // Remove duplicates
        list.removeDuplicates();

        System.out.println("List after removing duplicates:");
        list.printList();
    }
}
