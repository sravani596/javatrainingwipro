
	package com.wipro.java8;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo {

		public static void main(String[] args) {

				
		//MyInterface mi =	(int a,int b) ->{ return a+b;};
		
				//System.out.println("Add value : "+  mi.add(5, 5));
			
	//MyInterface mi =  (String name) -> {return name.length();};
		
			
			//MyInterface mi =  s1 ->  s1.length();
		
		//System.out.println("Length is: "+mi.findLength("Javeed"));
			Consumer<String> consumer = (String str)-> System.out.println(str);

			consumer.accept("Hello LEI");
			Supplier<String> supplier = () -> "Hello from Supplier!";

			consumer.accept(supplier.get());
			
			//even number test

			Predicate<Integer> predicate = num -> num%2==0;

			System.out.println(predicate.test(24));

			System.out.println(predicate.test(21));

			//max test

			BiFunction<Integer, Integer, Integer> maxFunction = (x,y)->x>y?x:y;

			System.out.println(maxFunction.apply(25, 14));



		}

	}



