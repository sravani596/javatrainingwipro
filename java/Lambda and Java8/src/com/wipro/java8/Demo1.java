package com.wipro.java8;

public class Demo1 {
	
	//import java.util.function;


		public static void main(String[] args) {
			
			ConsumerInterface consumer = (String str) -> System.out.println(str);
			consumer.accept("From Consumer Interface");
			
			SupplierInterface supplier = () -> "From Supplier Interface";
			consumer.accept(supplier.get());
			
			PredicateInterface predicate = (int num) -> {return num%2==0;};
			System.out.println(predicate.test(24));
			System.out.println(predicate.test(21));
			
			FunctionInterface function = (int x,int y) -> {return x>y?x:y;};
			System.out.println(function.apply(25,14));
		}

	}