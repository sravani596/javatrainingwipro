package com.wipro.Day_19;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Supplier;

// Person class with name and age
class PersonDetails {
    private String name;
    private int age;

    public PersonDetails(String name, int age) {
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

public class FunctionalInterfacesDemo {

    // Method that uses Predicate to check if a person is an adult
    public static boolean isAdult(Person person, Predicate<Person> predicate) {
        return predicate.test(person);
    }

    // Method that uses Function to get the age of a person
    public static int getAge(Person person, Function<Person, Integer> function) {
        return function.apply(person);
    }

    // Method that uses Consumer to print a person's details
    public static void printPerson(Person person, Consumer<Person> consumer) {
        consumer.accept(person);
    }

    // Method that uses Supplier to create a default person
    public static Person createDefaultPerson(Supplier<Person> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        Person person = new Person("Alice", 30);

        // Using Predicate to check if the person is an adult
        boolean isAdult = isAdult(person, p -> p.getAge() >= 18);
        System.out.println("Is the person an adult? " + isAdult);

        // Using Function to get the person's age
        int age = getAge(person, Person::getAge);
        System.out.println("Person's age: " + age);

        // Using Consumer to print the person's details
        printPerson(person, p -> System.out.println("Person details: " + p));

        // Using Supplier to create a default person
        Person defaultPerson = createDefaultPerson(() -> new Person("Default", 0));
        System.out.println("Default person: " + defaultPerson);
    }
}
