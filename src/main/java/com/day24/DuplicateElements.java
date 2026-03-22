package com.day24;

import java.util.HashSet;
import java.util.Set;

public class DuplicateElements {

	public static void main(String[] args) {
		int input[] = { 10, 20, 30, 40, 40, 10 };

		Set<Integer> inputSet = new HashSet<Integer>();

		for (int number : input) {
			// System.out.println(inputSet.add(number) + " " + number);

			// to print the duplicates in an array
			if (!inputSet.add(number)) {
				System.out.println("The duplicate elements in given array:" + number);
			}
		}

	}

}
