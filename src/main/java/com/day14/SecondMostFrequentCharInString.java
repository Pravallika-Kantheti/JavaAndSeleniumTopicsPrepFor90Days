package com.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SecondMostFrequentCharInString {

	public static void main(String[] args) {
		// find the second most frequent character in a string//always use map- hashmap
		// for frequency

		String input = "aab21 bbava1";
		System.out.println("The input String is: " + input);

		int firstMaxFreq = 0;
		int secondMaxFreq = 0;

		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();

		for (char c : input.toCharArray()) {
			if (Character.isLetter(c) || Character.isDigit(c))
				hmap.put(c, hmap.getOrDefault(c, 0) + 1);
		}

		System.out.println(hmap);

		for (Map.Entry<Character, Integer> entrySet : hmap.entrySet()) {
			int currentFreq = entrySet.getValue();
			if (currentFreq > firstMaxFreq) {
				secondMaxFreq = firstMaxFreq;
				firstMaxFreq = currentFreq;
			} else if (currentFreq > secondMaxFreq && currentFreq < firstMaxFreq) {
				secondMaxFreq = currentFreq;
			}
		}

		System.out.println(secondMaxFreq);
		
		for(Map.Entry<Character, Integer> entrySet: hmap.entrySet()) {
			
			if(entrySet.getValue() == secondMaxFreq) {
				System.out.println("The Second Most frequent character in string is: " + entrySet.getKey() +" which appeared to be " + entrySet.getValue());
			}
		}

	}

}
