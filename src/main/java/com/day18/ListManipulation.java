package com.day18;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ListManipulation {

	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 22, 32, null, 123, 100);

		// to do some filteration we need to use streams()

		List<Integer> numberList2 = numberList.stream().filter(i -> Objects.nonNull(i))
				.filter(i -> i.toString().startsWith("1")).collect(Collectors.toList());

		System.out.println("The list numbers start with 1:" + numberList2);

	}

}
