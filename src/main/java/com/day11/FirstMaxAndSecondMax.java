package com.day11;

public class FirstMaxAndSecondMax {

	public static void main(String[] args) {
		int a[] = { -1, 3, 4, 10, 2, 5, 6, 15, 12 };

		int firstMax = Integer.MIN_VALUE;
		int secondMax = Integer.MIN_VALUE;
		int thirdMax = Integer.MIN_VALUE;

		// System.out.println("the min value of firstMax:" +firstMax); the min value of
		// firstMax:-2147483648

		// we can sort the list and know the first and second max values. but this is
		// expensive. so sort will be the last option here.
		// we use Single Pass approach - in one traverse we will know the first and
		// second max without sort. This is efficient.

		for (int num : a) {
			if (num > firstMax) {
				thirdMax = secondMax;
				secondMax = firstMax;
				firstMax = num;
			} else if (num > secondMax && num <= firstMax) {
				secondMax = num;
			} else if (num > thirdMax && num <= secondMax) {
				thirdMax = num;
			}
		}

		System.out.println("The first Max value in the list is:" + firstMax);
		System.out.println("The second Max value in the list is:" + secondMax);
		System.out.println("The Third Max value in the list is:" + thirdMax);

	}

}
