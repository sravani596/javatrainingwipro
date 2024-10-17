package com.wipro.Day_19;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class ExampleClass {
    private String privateField = "Initial Value";

    private void privateMethod() {
        System.out.println("Private method called");
    }

    public void publicMethod() {
        System.out.println("Public method called");
    }

    public ExampleClass() {
        System.out.println("Constructor called");
    }
}

public class ReflectionDemo {

    public static void main(String[] args) {
        try {
            // Get the Class object for ExampleClass
            Class<?> clazz = ExampleClass.class;

            // Inspecting methods
            System.out.println("Methods:");
            for (Method method : clazz.getDeclaredMethods()) {
                System.out.println(method.getName());
            }

            // Inspecting fields
            System.out.println("\nFields:");
            for (Field field : clazz.getDeclaredFields()) {
                System.out.println(field.getName());
            }

            // Inspecting constructors
            System.out.println("\nConstructors:");
            for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
                System.out.println(constructor.getName());
            }

            // Modifying private field value
            ExampleClass example = new ExampleClass();
            Field privateField = clazz.getDeclaredField("privateField");
            privateField.setAccessible(true); // Make the private field accessible
            System.out.println("\nOriginal value of privateField: " + privateField.get(example));

            // Set new value to the private field
            privateField.set(example, "Modified Value");
            System.out.println("Modified value of privateField: " + privateField.get(example));

            // Invoking private method
            Method privateMethod = clazz.getDeclaredMethod("privateMethod");
            privateMethod.setAccessible(true); // Make the private method accessible
            privateMethod.invoke(example);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
