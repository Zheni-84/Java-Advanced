package TestingMethods;

import java.util.Date;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {

		final String datesString = formatDates("05/08/2022", "");
		System.out.println(datesString);

	}

	private static String formatDates(String... values) {
		return Stream.of(values)
				.filter(Objects::nonNull)
				.collect(Collectors.joining(" - "));
	}

}
