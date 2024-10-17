package datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DateTimeAPIs {

	public static void main(String[] args) {


	LocalDate  date =	LocalDate.now();
	
	System.out.println(date);
	
		System.out.println("Year "+date.getYear());
		System.out.println("month day "+date.getDayOfMonth());
		System.out.println("week day "+date.getDayOfWeek());
		
	
			System.out.println("Plus 1 month "+date.plusMonths(1));
			
			System.out.println("minus 3 yrs "+date.minusYears(3));
			
		
	
	 LocalTime  time =  LocalTime.now();
	
	 System.out.println(time);
	 
	 System.out.println(time.getHour());
	 
	 
	 	LocalDateTime  dateTime =	LocalDateTime.now();
	 	
	 	System.out.println(dateTime.getMonthValue());
	 	
	 	
	 	
	 	LocalDate  indate =	LocalDate.of(1947, 8, 15);
	 	
	 			System.out.println(indate);
	 			
	 	
	 			
	 			System.out.println("after "+date.isAfter(indate));
	 			
	 			System.out.println("before "+indate.isBefore(date));
	 	
	 	
	 			System.out.println("is leap yr "+date.isLeapYear());
		

	}

}
