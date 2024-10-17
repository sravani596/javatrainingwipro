package com.wipro.Day_20;
import java.io.*;

// Custom class that implements Serializable
class Person implements Serializable {
    private static final long serialVersionUID = 1L; // A unique ID for serialization
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class SerializationDemo {

    public static void main(String[] args) {
        String filePath = "person.ser"; // File to store the serialized object

        // Create a Person object
        Person person = new Person("Alice", 30);

        // Serialize the Person object
        serializeObject(person, filePath);

        // Deserialize the Person object
        Person deserializedPerson = deserializeObject(filePath);

        // Print the deserialized Person object
        if (deserializedPerson != null) {
            System.out.println("Deserialized Person: " + deserializedPerson);
        }
    }

    // Method to serialize an object to a file
    private static void serializeObject(Person person, String filePath) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(person);
            System.out.println("Object serialized to " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to deserialize an object from a file
    private static Person deserializeObject(String filePath) {
        Person person = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            person = (Person) ois.readObject();
            System.out.println("Object deserialized from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return person;
    }
}
