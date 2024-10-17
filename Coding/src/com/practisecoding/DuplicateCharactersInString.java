package com.practisecoding;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicateCharactersInString {
	
	
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to number of duplicate characters: ");
        String input = scanner.nextLine();

        findDuplicateCharacters(input);

        scanner.close();
    }

    public static void findDuplicateCharacters(String str) {
        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        System.out.println("Duplicate characters in the string:");
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
    }

}
