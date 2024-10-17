package com.practisecoding;

public class ConstructorOverload {
    
    int num1; 
    
    public ConstructorOverload(int num2) {
        num1 = num2; 
    }
    
    public ConstructorOverload(int num2, int num3) {
        System.out.println("Assigning max value of num2 and num3 to num1");
        
        if (num2 > num3) {
            num1 = num2;
        } else {
            num1 = num3;
        }
    }
    
    public static void main(String[] args) {
        ConstructorOverload obj = new ConstructorOverload(10);
        System.out.println(obj.num1);  // Output: 10
    }
}
