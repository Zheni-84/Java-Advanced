package advanced.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomMinFunction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		Function<int[], Integer> smallestElement = (int[] arr) -> {
			int min = Integer.MAX_VALUE;
			for (int num : arr) {
				if (num < min) {
					min = num;
				}
			}
			return min;
		};

		Function<int[], Integer> smallestSimpleSolution1 = arr -> Arrays.stream(arr).min().getAsInt();

		Function<int[], Integer> smallestSimpleSolution2 = arr -> Collections
				.min(Arrays.stream(arr)
						.boxed()
						.collect(Collectors.toList()));

		System.out.println(smallestElement.apply(numbers));
	}

}
