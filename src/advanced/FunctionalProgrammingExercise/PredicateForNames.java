package advanced.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int nameLen = Integer.parseInt(sc.nextLine());
		List<String> names = Arrays.stream(sc.nextLine().split("\\s+"))
				.collect(Collectors.toList());

		Predicate<String> predicate = name -> name.length() <= nameLen;

		names.stream().filter(predicate).forEach(System.out::println);
	}

}
