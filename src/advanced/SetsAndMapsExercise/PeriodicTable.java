package advanced.SetsAndMapsExercise;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int number = Integer.parseInt(sc.nextLine());

		TreeSet<String> elements = new TreeSet<>();
		for (int i = 0; i < number; i++) {
			String[] elementInput = sc.nextLine().split(" ");
			Collections.addAll(elements, elementInput);
			elements.addAll(List.of(elementInput));
		}
		System.out.println(String.join(" ", elements));
	}

}
