package advanced.IteratorsAndComparators.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		List<Person> people = new ArrayList<>();
		while (!input.equals("END")) {
			String[] peopleData = input.split(" ");
			String name = peopleData[0];
			int age = Integer.parseInt(peopleData[1]);
			String town = peopleData[2];

			Person person = new Person(name, age, town);
			people.add(person);
			input = sc.nextLine();
		}
		int compareIndex = Integer.parseInt(sc.nextLine());
		Person personToCompare = people.get(compareIndex - 1);

		int totalPeoppe = people.size();
		int samePeople = 0;
		int differentPeople = 0;
		for (Person person : people) {
			if (person.compareTo(personToCompare) == 0){
				samePeople++;
			}else {
				differentPeople++;
			}
		}
		if (samePeople == 1){
			System.out.println("No matches");
		}else {
			System.out.printf("%d %d %d", samePeople, differentPeople, totalPeoppe);
		}
	}
}
