package com.wipro.Day_20;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TimezoneConverter {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Define the date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            // Read the date-time from the user
            System.out.print("Enter the date-time (yyyy-MM-dd HH:mm:ss): ");
            String dateTimeString = scanner.nextLine();
            ZonedDateTime dateTime = ZonedDateTime.parse(dateTimeString + "Z", formatter.withZone(ZoneId.of("UTC")));

            // Read the source and target timezones from the user
            System.out.print("Enter the source timezone (e.g., America/New_York): ");
            String sourceTimezone = scanner.nextLine();
            System.out.print("Enter the target timezone (e.g., Europe/London): ");
            String targetTimezone = scanner.nextLine();

            // Convert the date-time to the source timezone
            ZonedDateTime sourceDateTime = dateTime.withZoneSameInstant(ZoneId.of(sourceTimezone));

            // Convert the date-time to the target timezone
            ZonedDateTime targetDateTime = sourceDateTime.withZoneSameInstant(ZoneId.of(targetTimezone));

            // Output the result
            System.out.println("Source Timezone Date-Time: " + sourceDateTime.format(formatter));
            System.out.println("Target Timezone Date-Time: " + targetDateTime.format(formatter));

        } catch (DateTimeParseException e) {
            System.out.println("Invalid date-time format. Please use yyyy-MM-dd HH:mm:ss.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the scanner
            scanner.close();
        }
    }
}
