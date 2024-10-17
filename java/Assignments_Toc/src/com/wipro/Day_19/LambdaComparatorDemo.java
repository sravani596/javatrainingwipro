package com.wipro.Day_19;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

// Person class with name and age
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name + " (" + age + " years old)";
    }
}

public class LambdaComparatorDemo {

    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> people = new ArrayList<>();
        people.add(new Person("Alice", 30));
        people.add(new Person("Bob", 25));
        people.add(new Person("Charlie", 35));
        people.add(new Person("David", 28));

        // Print the list before sorting
        System.out.println("Before sorting:");
        for (Person person : people) {
            System.out.println(person);
        }

        // Sort the list by age using a lambda expression
        Collections.sort(people, (p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

        // Print the list after sorting
        System.out.println("\nAfter sorting by age:");
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
