package ExamPreparation.June20.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
	private String name;
	private int capacity;
	private List<Person> roster;

	public Hotel(String name, int capacity) {
		this.name = name;
		this.capacity = capacity;
		this.roster = new ArrayList<>();
	}

	public void add(Person person) {
		if (this.roster.size() < this.capacity){
			this.roster.add(person);
		}
	}

	public boolean remove(String name) {
		return this.roster.removeIf(person -> person.getName().equals(name));
	}

	public Person getPerson(String name, String homeTown) {
		return this.roster.stream()
				.filter(person-> person.getName().equals(name) && person.getHometown().equals(homeTown))
				.findFirst()
				.orElse(null);
	}

	public int getCount() {
		return this.roster.size();
	}

	public String getStatistics() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("The people in the ExamPreparation.June20.hotel %s are:%n", getName()));

		for (Person person : roster) {
			sb.append(String.format("%s%n", person.toString()));
		}

		return sb.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
