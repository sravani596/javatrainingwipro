package com.wipro.java8;

public class Demo {

	public static void main(String[] args) {

			
	//MyInterface mi =	(int a,int b) ->{ return a+b;};
	
			//System.out.println("Add value : "+  mi.add(5, 5));
		
//MyInterface mi =  (String name) -> {return name.length();};
	
		
		MyInterface mi =  s1 ->  s1.length();
	
	System.out.println("Length is: "+mi.findLength("Javeed"));


		
		MyInterface.m1();
		
		mi.m2();
		
		
		
		
	
	
	
	}

}
