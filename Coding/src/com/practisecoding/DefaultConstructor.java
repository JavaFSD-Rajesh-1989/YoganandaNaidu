package com.practisecoding;

public class DefaultConstructor {
	
	
	int id; 
	
	String name; 
	
	void display() {
		System.out.println(id +" "+ name);
	}
	
	public static void main(String args[]){
		
		DefaultConstructor obj = new DefaultConstructor(); 
		
		obj.display();
	}

}
