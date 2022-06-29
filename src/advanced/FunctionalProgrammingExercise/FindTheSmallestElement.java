package advanced.FunctionalProgrammingExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
				.map(Integer::parseInt)
				.collect(Collectors.toList());

		Function<List<Integer>, Integer> minElemIndex = intList -> {
			int minElem = intList.stream().mapToInt(e -> e).min().getAsInt();
			return intList.lastIndexOf(minElem);
		};
		Function<List<Integer>, Integer> minElemFunc = intList -> {
			int minEl = Integer.MAX_VALUE;
			int minIndex = -1;
			for (int i = 0; i < intList.size(); i++) {
				if (intList.get(i) <= minEl) {
					minEl = intList.get(i);
					minIndex = i;
				}
			}
			return minIndex;
		};
		System.out.println(minElemFunc.apply(list));
	}

}
