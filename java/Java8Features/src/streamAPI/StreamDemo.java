package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamDemo {

	public static void main(String[] args) {


		List<Integer>  list = new ArrayList<Integer>();
		
		list.add(20);
		list.add(50);
		list.add(30);
		list.add(10);
		list.add(70);
		list.add(20);
		list.add(50);
			
			
				Stream<Integer> stream1 =	list.stream();
			
		
		stream1.forEach( (Integer num)->{ System.out.println(num);}  );
		
	
		Stream<Integer> stream2 =	list.stream();
		
		
		System.out.println("filter and print");
		
			stream2.filter( (Integer num)->{  return  num > 30;} )
			       .forEach((Integer num)->{ System.out.println(num);});
				
			
			Stream<Integer> stream3 =	list.stream();
			
			//System.out.println("limit operator");
					//stream3.limit(3).forEach(System.out::println);
			
			//System.out.println("skip operator");
			//stream3.skip(3).forEach(System.out::println);
			
			
			//System.out.println("distinct operator");
			//stream3.distinct().forEach(System.out::println);
			
		Integer sum=	stream3.reduce((n1,n2)->{ return n1+n2; }).orElse(0);
					
				
					System.out.println("Sum total "+sum);
			
		
	}

}
