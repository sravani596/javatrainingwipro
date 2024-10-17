package com.wipro.Day_7n8;
import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList; // Adjacency list representation of the graph

    // Constructor to initialize the graph
    public Graph() {
        adjList = new HashMap<>();
    }

    // Function to add a node to the graph
    public void addNode(int node) {
        adjList.putIfAbsent(node, new ArrayList<>());
    }

    // Function to add an edge from 'from' to 'to' if it doesn't create a cycle
    public boolean addEdge(int from, int to) {
        addNode(from);
        addNode(to);

        // Temporarily add the edge
        adjList.get(from).add(to);

        // Check if adding this edge creates a cycle
        if (hasCycle()) {
            // If a cycle is detected, remove the edge and return false
            adjList.get(from).remove((Integer) to);
            return false;
        }
        return true;
    }

    // Function to check if the graph has a cycle
    private boolean hasCycle() {
        Set<Integer> visited = new HashSet<>();
        Set<Integer> recStack = new HashSet<>();

        for (Integer node : adjList.keySet()) {
            if (isCyclicUtil(node, visited, recStack)) {
                return true;
            }
        }
        return false;
    }

    // Helper function for cycle detection using DFS
    private boolean isCyclicUtil(int node, Set<Integer> visited, Set<Integer> recStack) {
        if (recStack.contains(node)) {
            return true; // Found a cycle
        }
        if (visited.contains(node)) {
            return false; // Already visited
        }

        // Mark the node as visited and add it to the recursion stack
        visited.add(node);
        recStack.add(node);

        // Recur for all vertices adjacent to this node
        for (Integer neighbor : adjList.get(node)) {
            if (isCyclicUtil(neighbor, visited, recStack)) {
                return true;
            }
        }

        // Remove the node from recursion stack
        recStack.remove(node);
        return false;
    }

    // Function to display the graph
    public void printGraph() {
        for (Map.Entry<Integer, List<Integer>> entry : adjList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            for (Integer neighbor : entry.getValue()) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        // Add edges and check for cycles
        System.out.println("Adding edge 1 -> 2: " + graph.addEdge(1, 2)); // true
        System.out.println("Adding edge 2 -> 3: " + graph.addEdge(2, 3)); // true
        System.out.println("Adding edge 3 -> 4: " + graph.addEdge(3, 4)); // true
        System.out.println("Adding edge 4 -> 2: " + graph.addEdge(4, 2)); // false (creates a cycle)

        // Print the graph to see the final structure
        graph.printGraph();
    }
}
