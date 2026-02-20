package com.day12;

public class MountainPattern {

	public static void main(String[] args) {
//		1
//		1 2
//		1 2 3
//		1 2 3 4
//		1 2 3 4 5
//		1 2 3 4 
//		1 2 3 
//		1 2
//		1

		// we will use nested loop to solve this pattern
		int n = 5;

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}

			System.out.println("");
		}

		for (int row = n - 1; row >= 1; row--) {
			for (int col = 1; col <= row; col++) {
				System.out.print(col);
			}
			System.out.println("");
		}
	}

}
