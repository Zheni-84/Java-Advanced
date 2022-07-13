package oop.interfacesAndAbstraction.foodShortage;

public class Citizen implements Buyer, Person, Birthable, Identifiable {

	private final String name;
	private int age;
	private String id;
	private String birthDate;
	private int food;

	public Citizen(String name, int age, String id, String getBirthDate) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.birthDate = getBirthDate;
		this.food = 0;
	}

	public Citizen(String name) {
		this.name = name;
		this.food = 0;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getBirthDate() {
		return birthDate;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void buyFood() {
		food += 10;
	}

	@Override
	public int getFood() {
		return food;
	}
}
