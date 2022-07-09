package oop.inheritance.animals;

public class Animal {

	private String name;
	private int age;
	private String gender;

	public Animal(String name, int age, String gender) {
		setName(name);
		setAge(age);
		setGender(gender);
	}

	@Override
	public String toString() {
		String animalData = String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), name, age, gender, produceSound());
		return animalData.trim();
	}

	public String produceSound() {
		return "";
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public void setName(String name) {
		checkEmptyInput(name);
		this.name = name;
	}

	public void setAge(int age) {
		checkEmptyInput(age);
		this.age = age;
	}

	public void setGender(String gender) {
		checkEmptyInput(gender);
		this.gender = gender;
	}

	private void checkEmptyInput(String input) {
		if (input == null || input.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid input!");
		}
	}

	private void checkEmptyInput(int input) {
		if (input < 0) {
			throw new IllegalArgumentException("Invalid input!");
		}
	}
}
