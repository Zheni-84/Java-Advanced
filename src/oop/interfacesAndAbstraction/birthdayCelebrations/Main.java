package oop.interfacesAndAbstraction.birthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		List<Birthable> birthableList = new ArrayList<>();

		String input = sc.nextLine();
		while (!input.equals("End")) {
			String[] inputParts = input.split(" ");
			String typeToCreate = inputParts[0];
			switch (typeToCreate) {
				case "Citizen":
					String citizenName = inputParts[1];
					int age = Integer.parseInt(inputParts[2]);
					String id = inputParts[3];
					String citizenBirthDate = inputParts[4];
					Citizen citizen = new Citizen(citizenName, age, id, citizenBirthDate);
					birthableList.add(citizen);
					break;
				case "Pet":
					String petName = inputParts[1];
					String birthDate = inputParts[2];
					Pet pet = new Pet(petName, birthDate);
					birthableList.add(pet);
					break;
				case "Robot":
					//TODO create robots
					break;
			}

			input = sc.nextLine();
		}

		String year = sc.nextLine();
		birthableList.stream()
				.map(Birthable::getBirthDate)
				.filter(date -> date.endsWith(year))
				.forEach(System.out::println);
	}

}
