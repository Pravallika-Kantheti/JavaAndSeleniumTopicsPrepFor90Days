package com.day18;

import java.util.Arrays;

public class ReverseString_Delloite {

	public static void main(String[] args) {

		String input = "Java Test";
		//the result will always be stored in stringBuilder which is immutable as we can manipulate 
		//where string is immutable everytime it creates a new string and is not memory efficient
		StringBuilder finalResult = new StringBuilder();

		String data[] = input.split(" ");
		System.out.println(Arrays.toString(data));

		for (String word : data) {
			char charArray[] = word.toCharArray();
			int left = 0;
			int right = charArray.length - 1;
			while (left < right) {
				char temp = charArray[left];
				charArray[left] = charArray[right];
				charArray[right] = temp;
				left++;
				right--;
			}
			//System.out.println(Arrays.toString(charArray));
			
			String result = new String(charArray);
			System.out.println(result);
			
			finalResult.append(result).append(" ");
		}
		
		System.out.println("The final reversed words in a string is: "+finalResult);

	}

}
