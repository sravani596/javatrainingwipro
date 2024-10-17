package join.sleep;



public class MyThread extends Thread {
	
	
	@Override
	public void run() {

		//System.out.println(Thread.currentThread().getName());

		for (int i = 0; i < 5; i++) {

			System.out.println(Thread.currentThread().getName());
			
				try {
					Thread.sleep(2000);  // thread sleep for 2sec
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   

		}

	}
	
	
	public static void main(String[] args) throws InterruptedException  {  // main thread
		
		
		MyThread t1 = new MyThread();
		
		  t1.start();
		  
		 t1.join(); 
		  // here main thread calling t1.join() and main will wait till t1 completes its execution
		 
		  
		 
		
		  for (int i = 0; i < 5; i++) {
		  
		  System.out.println("Main Thread");
		  
		  }
		 

		

		
		
	}
	
	

}
