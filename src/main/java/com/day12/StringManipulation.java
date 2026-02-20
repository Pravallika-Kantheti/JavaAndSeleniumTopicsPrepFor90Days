package com.day12;

public class StringManipulation {

	public static void main(String[] args) {
		//display the number of digits after the decimal
		
		double num = 12356.345689;
		//converting  the number to string??
		
		String input  = String.valueOf(num);
		System.out.println(input);
		
		int indexOfDecimal = input.indexOf(".");
		System.out.println("Index of decimal point in "+input+" is " +indexOfDecimal);
		
		int noOfDecimalDigits = input.length()-indexOfDecimal -1;
		System.out.println("No of digits after decimal in "+input+" is " +noOfDecimalDigits);

	}

}
