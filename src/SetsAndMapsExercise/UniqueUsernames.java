package SetsAndMapsExercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueUsernames {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numberOfUsernames = Integer.parseInt(sc.nextLine());
		LinkedHashSet<String> usernames = new LinkedHashSet<>();
		for (int i = 0; i < numberOfUsernames; i++) {
			String input = sc.nextLine();
			usernames.add(input);
		}
		usernames.forEach(System.out::println);
	}

}
