package com.day12;

public class EvenOrOdd {

	public static void main(String[] args) {
		//Display number is even or odd without using modulus, division or multiplication
		int num = 8;

		while (num > 1) {
			num = num - 2;
		}
		if (num == 0) {
			System.out.println("Number is Even");
		} else if (num == 1) {
			System.out.println("Number is Odd");
		}

	}

}
