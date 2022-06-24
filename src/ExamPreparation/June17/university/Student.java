package ExamPreparation.June17.university;

import java.util.Objects;

public class Student {

	public String firstName;
	public String lastName;
	public String bestSubject;

	public Student(String firstName, String lastName, String bestSubject) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bestSubject = bestSubject;
	}

	@Override
	public String toString() {
		return "Student: " + firstName + " " + lastName + ", " + bestSubject;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Student student = (Student) o;
		return Objects.equals(firstName, student.firstName) &&
				Objects.equals(lastName, student.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBestSubject() {
		return bestSubject;
	}

	public void setBestSubject(String bestSubject) {
		this.bestSubject = bestSubject;
	}
}
