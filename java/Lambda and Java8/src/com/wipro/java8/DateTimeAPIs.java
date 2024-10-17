package com.wipro.java8;

	import java.time.LocalDate;
	import java.time.LocalDateTime;
	import java.time.LocalTime;
	

	public class DateTimeAPIs {
	    public static void main(String[] args) {

	        // Get the current date
	        LocalDate date = LocalDate.now();
	        
	        System.out.println(date);

	        // Print the current date
	        System.out.println("Current date: " + date);

	        // Print the year
	        System.out.println("Year: " + date.getYear());

	        // Print the day of the month
	        System.out.println("Month day: " + date.getDayOfMonth());

	        // Print the day of the week
	        System.out.println("Week day: " + date.getDayOfWeek());
	        
	        System.out.println("Plus 1 month "+date.plusMonths(1));
	        
	        System.out.println("minus 3 yrs "+date.minusYears(3));

	        // Get the current time
	        LocalTime time = LocalTime.now();

	        // Print the current time
	        System.out.println("Current time: " + time);

	        // Print the current hour
	        System.out.println("Hour: " + time.getHour());
	        
	        LocalDateTime dateTime = LocalDateTime.now();
	        
	        System.out.println(dateTime.getMonthValue());
	        
	        LocalDate indate = LocalDate.of(1947,  8,  15);
	        
	        System.out.println(indate);
	        
	        System.out.println("after "+date.isAfter(indate));
	        
	        System.out.println("before "+date.isBefore(indate));
	        
	        System.out.println("is leap yr "+date.isLeapYear());

	        
	        
	        
	         
	        
	    }
	}


