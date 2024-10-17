package com.wipro.java8;

@FunctionalInterface
public interface MyInterface {

	
	//	public abstract int add(int a,int b);
		
	int  findLength(String name);
	
	
 public  static	void m1() {
		
	 
	 System.out.println("m1() static method from MyInterface");
		
	}
	
 
 public  default  void m2() {
	 
	 	System.out.println("m2() from MyInterface");
	 
 }
 
	
}
