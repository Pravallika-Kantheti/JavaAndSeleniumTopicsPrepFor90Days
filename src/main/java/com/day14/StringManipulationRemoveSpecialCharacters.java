package com.day14;

public class StringManipulationRemoveSpecialCharacters {

	public static void main(String[] args) {
		String input = "r@56vi ku$%mar67";
		// print rvi kumar 24(5+6=11 and 6+7=13 total 24)

		StringBuilder sb = new StringBuilder();
		int sum = 0;
		for (char c : input.toCharArray()) {
			if (Character.isLetter(c) || Character.isWhitespace(c)) {
				sb.append(c);
			} else if (Character.isDigit(c)) {
				sum = sum + Character.getNumericValue(c);
			}
		}
		
		System.out.println("The result after manipulation is: " + sb.append(" ").append(sum));
		
	}

}
