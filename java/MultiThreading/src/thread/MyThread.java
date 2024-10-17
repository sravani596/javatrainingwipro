package thread;

public class MyThread extends Thread  { // inheritance  IS-A Relationship

	@Override
	public  void run() {

		//System.out.println(Thread.currentThread().getName());

		
		
		for (int i = 0; i < 5; i++) {

			
				System.out.println(Thread.currentThread().getName());

			
			
			
		}

	}

	public static void main(String[] args) { // main thread JVMs thread

		/*
		 * for (int i = 0; i < 5; i++) {
		 * 
		 * System.out.println("Main Thread");
		 * 
		 * }
		 */

		MyThread t1 = new MyThread();

		t1.setPriority(5);
		t1.setName("child-1");

		System.out.println(t1);
		System.out.println(t1.getState());
		
		
		MyThread t2 = new MyThread();  // default priority is 5
			t2.setName("child-2");
		
		

		t1.start(); // ----> t1.run();
		
		t2.start(); // -------> t2.run();

	}

}
