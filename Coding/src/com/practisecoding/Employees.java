package com.practisecoding;

class Employees extends Person{
	

	float salary; 
	
	
	public Employees(String name, String address, float salary) {
		super(name, address);
		this.salary = salary;
	}
	
	
	public class Testing{
		
		
		public static void main(String[] args) {
			
			Employees emp = new Employees("Yogananda", "Anantapur", 10000);
			System.out.println(emp.name+" "+emp.address+" "+emp.salary);
		}
	}
	

	
	

}
