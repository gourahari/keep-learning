package com.goura.designpatternsinj8;

import java.awt.Color;
import java.util.function.Function;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class DecoratorPatternColorExample {

	public static void main(String[] args) {
		drawIt(new Figure());
		drawIt(new Figure(Color::darker));
		drawIt(new Figure(Color::brighter));

		drawIt(new Figure(Color::brighter, Color::darker));
	}

	public static void drawIt(Figure figure) {
		System.out.println(figure.draw(new Color(125, 125, 125)));
	}
}

@SuppressWarnings("unchecked")
class Figure {
	Function<Color, Color> filter;

	public Figure(Function<Color, Color>... filters) {
		setFilters(filters);
	}

	private void setFilters(Function<Color, Color>... filters) {
		/*filter = Stream.of(filters)
					.reduce(color -> color, (thefilters, aFilter) -> thefilters.andThen(aFilter));*/

		// Same as above.
		filter = Stream.of(filters)
				.reduce(Function.identity(), Function::andThen);
	}

	public Color draw(Color color) {
		return filter.apply(color);
	}	
}
