package streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOperators {

	public static void main(String[] args) {


		
	List<String>  list =		   Arrays.asList("apple","mango","guava","pineapple","kiwi");
		
					//map
					Stream<String> stream1 =	list.stream();
	
					List<Integer> list2 =	stream1.map((str)->{ return  str.length(); })
								
									.collect(Collectors.toList());
								
	
		
						System.out.println(list2);
						
						//filter
						
						Stream<String> stream2 =	list.stream();
	
						
						stream2.filter((str)->{ return str.contains("e"); }  )
								.forEach(System.out::println);
						
						
						//count
						
						Stream<String> stream3 =	list.stream();
						
						
	}

}
