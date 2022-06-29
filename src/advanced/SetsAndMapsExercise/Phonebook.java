package advanced.SetsAndMapsExercise;

import java.util.HashMap;
import java.util.Scanner;

public class Phonebook {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<String, String> phonebook = new HashMap<>();
		String input = sc.nextLine();

		while (!input.equals("search")) {
			String[] inputTokens = input.split("-");
			String name = inputTokens[0];
			String phone = inputTokens[1];
			phonebook.put(name, phone);
			input = sc.nextLine();
		}
		input = sc.nextLine();
		while (!input.equals("stop")) {
			if (phonebook.containsKey(input)) {
				System.out.printf("%s -> %s%n", input, phonebook.get(input));
			}else {
				System.out.printf("Contact %s does not exist.%n", input);
			}
			input = sc.nextLine();
		}
	}

}
