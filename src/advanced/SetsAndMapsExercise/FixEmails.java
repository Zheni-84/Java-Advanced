package advanced.SetsAndMapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String name = sc.nextLine();
		LinkedHashMap<String, String> emails = new LinkedHashMap<>();

		while (!name.equals("stop")) {
			String email = sc.nextLine();
			if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
				emails.put(name, email);
			}
			name = sc.nextLine();
		}

		for (Map.Entry<String, String> pair : emails.entrySet()) {
			System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
		}
	}

}
