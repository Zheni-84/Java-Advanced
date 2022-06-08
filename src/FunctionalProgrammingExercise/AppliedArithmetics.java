package FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		UnaryOperator<List<Integer>> addFunction = list -> list.stream().map(el -> el + 1).collect(Collectors.toList());
		UnaryOperator<List<Integer>> subtractFunction = list -> list.stream().map(el -> el - 1).collect(Collectors.toList());
		UnaryOperator<List<Integer>> multiplyFunction = list -> list.stream().map(el -> el * 2).collect(Collectors.toList());

		String input = sc.nextLine();
		while (!input.equals("end")) {
			switch (input) {
				case "add":
					numbers = addFunction.apply(numbers);
					break;
				case "subtract":
					numbers = subtractFunction.apply(numbers);
					break;
				case "multiply":
					numbers = multiplyFunction.apply(numbers);
					break;
				case "print":
					numbers.forEach(number -> System.out.printf("%d ", number));
					System.out.println();
					break;
				default:
					break;
			}
			input = sc.nextLine();
		}
	}

}
