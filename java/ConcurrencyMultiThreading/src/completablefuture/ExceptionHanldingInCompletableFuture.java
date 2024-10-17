package completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExceptionHanldingInCompletableFuture {

	public static void main(String[] args)  {


		
		CompletableFuture<Integer> div = CompletableFuture.supplyAsync(() -> {

			return 	  10/0;

		}).exceptionally( e -> {return 0;} );
		
		
		try {
			System.out.println(div.get());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}

}
