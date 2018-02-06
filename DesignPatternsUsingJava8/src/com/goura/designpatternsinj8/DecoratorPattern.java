package com.goura.designpatternsinj8;

import java.util.function.Function;

public class DecoratorPattern {

	public static void main(String[] args) {
		Function<Integer, Integer> increment = e -> e + 5;
		Function<Integer, Integer> multiply = e -> e * 10;

		perform(2, increment);
		perform(2, multiply);
		perform(2, increment.andThen(multiply));
		perform(2, increment.andThen(multiply).andThen(increment));
	}

	private static void perform(int value, Function<Integer, Integer> func) {
		System.out.println(func.apply(value));
	}
}
