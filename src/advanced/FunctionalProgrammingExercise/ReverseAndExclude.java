package advanced.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.boxed()
				.collect(Collectors.toList());
		int n = Integer.parseInt(sc.nextLine());
		Predicate<Integer> predicate = number -> number % n == 0;
		numbers.removeIf(predicate);
		Collections.reverse(numbers);
		numbers.forEach(number -> System.out.print(number + " "));
	}

}
