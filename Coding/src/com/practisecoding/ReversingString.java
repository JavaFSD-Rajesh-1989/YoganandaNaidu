package com.practisecoding;

import java.util.Scanner;

public class ReversingString {
	
	
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string : ");
        String input = scanner.nextLine();
        
        String reversed = reverseString(input);
        
        System.out.println("Reversed String: " + reversed);
        
        scanner.close();
    }

    public static String reverseString(String str) 
    {
        char[] charArray = str.toCharArray();
        String result = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            result += charArray[i];
        }
        return result;
    }

}
