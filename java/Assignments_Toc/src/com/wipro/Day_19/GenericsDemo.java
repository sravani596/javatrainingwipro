package com.wipro.Day_19;
// Generic Pair class that holds two objects of different types
class Pair<T1, T2> {
    private final T1 first;
    private final T2 second;

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public T2 getSecond() {
        return second;
    }

    // Method to reverse the pair
    public Pair<T2, T1> reverse() {
        return new Pair<>(second, first);
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }
}

public class GenericsDemo {

    public static void main(String[] args) {
        // Create a Pair instance with Integer and String
        Pair<Integer, String> pair = new Pair<>(1, "Hello");
        System.out.println("Original Pair: " + pair);

        // Get the reversed Pair
        Pair<String, Integer> reversedPair = pair.reverse();
        System.out.println("Reversed Pair: " + reversedPair);
    }
}
