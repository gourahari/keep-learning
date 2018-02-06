package com.goura.designpatternsinj8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StrategyPattern {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// We inject different functional strategies using the predicate.

		// Using lambda expression
		System.out.println("Total of all the values: " + totalValues(numbers, n -> true));
		System.out.println("Total of all even values: " + totalValues(numbers, n -> n%2 == 0));
		System.out.println("Total of all odd values: " + totalValues(numbers, n -> n%2 != 0));

		// Using a function reference.
		System.out.println("Total of all the values: " + totalValues(numbers, n -> true));
		System.out.println("Total of all even values: " + totalValues(numbers, Util::isEven));
		System.out.println("Total of all odd values: " + totalValues(numbers, Util::isOdd));
	}

	private static int totalValues(List<Integer> numbers, Predicate<Integer> selector) {
		return numbers.stream()
			   .filter(selector)
			   .reduce(0, Integer::sum);
	}
}

class Util {
	public static boolean isOdd(int number) {
		return number%2 != 0;
	}

	public static boolean isEven(int number) {
		return number%2 == 0;
	}
}
