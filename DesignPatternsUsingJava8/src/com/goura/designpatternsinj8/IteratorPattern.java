package com.goura.designpatternsinj8;

import java.util.Arrays;
import java.util.List;

public class IteratorPattern {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		// Internal Iterator
		numbers.forEach(System.out::println);
	}

}
