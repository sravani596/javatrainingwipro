package synchronization;

public class Admission implements Runnable {

	
	static int seats = 1;
	
	@Override
	public synchronized void run() {  // at a time one thread can execute it

		if(seats > 0) {
			
	System.out.println("Congratulations "+Thread.currentThread().getName());
	System.out.println("Seat allocated to You");
	
		seats = seats-1;
			
		}
		else {
			
			System.err.println("Sorry! "+Thread.currentThread().getName()+" try next year");
			
		}
		
		
		System.out.println("No. of seats after  "+seats);
	}
	
	public static void main(String[] args) {
		
		
		Runnable  admission =	new Admission();  // resource
		
		// here 5 is priority which is assume  their rank in entrance exam
		
	Thread   t1 = new Thread(admission, "Raju");  // t1 is student raju
		
	Thread   t2 = new Thread(admission, "Satish");  // t2 is student satish
			
		System.out.println("No. of seats before  "+seats);
	
				t1.start();
				
				t2.start();
			
			
			
	}
	
	

}
