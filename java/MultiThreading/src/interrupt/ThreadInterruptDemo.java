package interrupt;

public class ThreadInterruptDemo {

	public static void main(String[] args) {
		MyThread t = new MyThread();
		t.start();
		 t.interrupt();
		System.out.println("end of main thread");
	}

}

class MyThread extends Thread {
	public void run() {
		try

		{
			for (int i = 0; i < 5; i++) {
				System.out.println("i am lazy Thread :" + i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			System.out.println("i got interrupted");
		}
	}
}