package com.wipro.java8;


	import java.util.ArrayList;
	import java.util.List;
	import java.util.stream.Collectors;

	public class StreamArrayListExample {
	    public static void main(String[] args) {
	        // Creating an ArrayList of integers
	        ArrayList<Integer> numbers = new ArrayList<>();
	        numbers.add(10);
	        numbers.add(15);
	        numbers.add(8);
	        numbers.add(49);
	        numbers.add(25);
	        numbers.add(98);
	        numbers.add(32);

	        // Using Stream API to filter even numbers and sort them
	        List<Integer> evenNumbers = numbers.stream()
	                .filter(n -> n % 2 == 0)  // Filter even numbers
	                .sorted()                 // Sort the numbers
	                .collect(Collectors.toList()); // Collect to a List

	        // Print the resulting list
	        System.out.println(evenNumbers);
	    }
	}


