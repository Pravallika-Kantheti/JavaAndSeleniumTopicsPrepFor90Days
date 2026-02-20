package com.day14;

import java.util.ArrayList;
import java.util.List;

public class StringManipulationReverse {

	public static void main(String[] args) {
		// "a1b2c3" to print "a3b2c1"

		String input = "a1b2c3";
		System.out.println("The input string is: " + input);
		List<Character> list = new ArrayList<Character>();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				list.add(c);
			}
		}

		int index = list.size() - 1;

		StringBuilder sb = new StringBuilder();
		for (char c : input.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(list.get(index));
				index--;
			} else {
				sb.append(c);
			}
		}
		System.out.println("The result after manipulation is: " + sb);
	}

}
