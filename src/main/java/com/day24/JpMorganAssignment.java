package com.day24;

import java.util.Arrays;

public class JpMorganAssignment {

	public static void main(String[] args) {
		int input[] = { 1, 3, 0, 4, 5, 0, 2, 0 };// to display {1, 2, 3, 4, 5, 0, 0, 0}
		int index = 0;
		System.out.println(Arrays.toString(input));

		for (int number : input) {
			if (number != 0) {
				input[index] = number;
				index++;
				// System.out.print(number);
			}
		}

		for (int i = index; i < input.length; i++) {
			input[i] = 0;
		}
		System.out.println(" Index = " + index);

		Arrays.parallelSort(input, 0, index);
		System.out.println(Arrays.toString(input));

	}

}
