package advanced.SetsAndMapsExercise;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] setSizes = Arrays.stream(sc.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		int firstSize = setSizes[0];
		LinkedHashSet<String> firstSet = new LinkedHashSet<>();
		for (int i = 0; i < firstSize; i++) {
			firstSet.add(sc.nextLine());
		}
		int secondSize = setSizes[1];
		LinkedHashSet<String> secondSet = new LinkedHashSet<>();
		for (int i = 0; i < secondSize; i++) {
			secondSet.add(sc.nextLine());
		}

		firstSet.retainAll(secondSet);
		System.out.println(String.join(" ", firstSet));
	}

}
