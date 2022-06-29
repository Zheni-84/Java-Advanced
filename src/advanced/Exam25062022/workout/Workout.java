package advanced.Exam25062022.workout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Workout {

	private String type;
	private int exerciseCount;
	private List<Exercise> exercises;

	public Workout(String type, int exerciseCount) {
		this.type = type;
		this.exerciseCount = exerciseCount;
		this.exercises = new ArrayList<>();
	}

	public void addExercise(Exercise exercise) {
		if (getExerciseCount() < this.exerciseCount) {
			this.exercises.add(exercise);
		}
	}

	public Exercise getExercise(String name, String muscle) {
		return this.exercises.stream()
				.filter(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle))
				.findFirst()
				.orElse(null);
	}

	public boolean removeExercise(String name, String muscle) {
		return this.exercises.removeIf(exercise -> exercise.getName().equals(name) && exercise.getMuscle().equals(muscle));
	}

	public int getExerciseCount() {
		return this.exercises.size();
	}

	public String getType() {
		return this.type;
	}

	public Exercise getMostBurnedCaloriesExercise() {
		if (this.exercises.isEmpty()) {
			return null;
		}

		return Collections.max(this.exercises, Comparator.comparingInt(Exercise::getBurnedCalories));
	}

	public String getStatistics() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Workout type: %s%n", this.getType()));

		for (Exercise exercise : exercises) {
			sb.append(String.format("%s%n", exercise.toString()));
		}

		return sb.toString().trim();
	}
}
