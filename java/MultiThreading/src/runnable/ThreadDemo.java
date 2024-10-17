package runnable;

public class ThreadDemo implements Runnable {

	@Override
	public void run() {


		System.out.println("run() is called...");
		
	}
	
	
	
		public static void main(String[] args) {
			
				
				Runnable  runnable  = new ThreadDemo();
				
				Thread t = new Thread(runnable); // HAS A Relationship	
			
						t.setName("Javeed Thread");
						
				
						t.start();  //runnable.run();
						
				
			
		}
	

}
