package com.wipro.Day_20;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DaysBetweenDates {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Read the first date from the user
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateString = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateString, formatter);

        // Read the second date from the user
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateString = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateString, formatter);

        // Calculate the number of days between the two dates
        long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

        // Output the result
        System.out.println("Number of days between the dates: " + daysBetween);

        // Close the scanner
        scanner.close();
    }
}
