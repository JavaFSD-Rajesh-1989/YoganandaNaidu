package com.practisecoding;

public class Employee {
	
	
	int empId; 
	
	String name; 
	
	Address address;

	public Employee(int empId, String name, Address address) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
	} 
	
	void display() {
		System.out.println(empId+" "+name);
		System.out.println(address.city+" "+address.state+" "+address.pincode);
	}
	
	
	static public void main(String []args) {
		
		Address address = new Address("Anantapur", "Andhra Pradesh", "515004");
		Employee emp = new Employee(101, "YoganandaNaidu", address);
		emp.display();
	}
	

}
