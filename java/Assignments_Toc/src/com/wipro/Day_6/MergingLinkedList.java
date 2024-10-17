package com.wipro.Day_6;
public class MergingLinkedList {

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

    // Function to merge two sorted linked lists
    public static Node mergeTwoLists(Node l1, Node l2) {
        // Create a dummy node to act as the head of the merged list
        Node dummy = new Node(0);
        Node current = dummy;

        // Traverse both lists and merge them in ascending order
        while (l1 != null && l2 != null) {
            if (l1.data <= l2.data) {
                current.next = l1;  // Attach l1 to the merged list
                l1 = l1.next;       // Move l1 to the next node
            } else {
                current.next = l2;  // Attach l2 to the merged list
                l2 = l2.next;       // Move l2 to the next node
            }
            current = current.next; // Move to the next node in the merged list
        }

        // If one list is exhausted, attach the remaining part of the other list
        if (l1 != null) {
            current.next = l1;
        } else {
            current.next = l2;
        }

        // Return the next of dummy node which is the head of the merged list
        return dummy.next;
    }

    // Function to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        Node l1 = new Node(1);
        l1.next = new Node(3);
        l1.next.next = new Node(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        Node l2 = new Node(2);
        l2.next = new Node(4);
        l2.next.next = new Node(6);

        System.out.println("List 1:");
        printList(l1);

        System.out.println("List 2:");
        printList(l2);

        // Merging the two sorted lists
        Node mergedList = mergeTwoLists(l1, l2);

        System.out.println("Merged List:");
        printList(mergedList);
    }
}
