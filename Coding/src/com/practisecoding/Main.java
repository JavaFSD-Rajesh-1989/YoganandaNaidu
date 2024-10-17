package com.practisecoding;

class Main {
	
	
	String name;
	
	Address address;
	
	public Main(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException{
		
		return super.clone();
	}
	
public class Person{
	
	   public static void main(String[] args) throws CloneNotSupportedException {
	        Address address = new Address("ATP","Andhra Pradesh","515004");
	        Main person1 = new Main("Yogananda", address);
	        Main person2 = (Main) person1.clone();  

	        System.out.println(person1.address.city); 
	        System.out.println(person2.address.city);  

	        person2.address.city = "Los Angeles"; 

	        System.out.println(person1.address.city); 
	        System.out.println(person2.address.city);  
	    }
}
	
	

}
