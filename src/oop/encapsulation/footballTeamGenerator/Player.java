package oop.encapsulation.footballTeamGenerator;

public class Player {

	private String name;
	private int endurance;
	private int sprint;
	private int dribble;
	private int passing;
	private int shooting;

	public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
		setName(name);
		setEndurance(endurance);
		setSprint(sprint);
		setDribble(dribble);
		setPassing(passing);
		setShooting(shooting);
	}

	public double overallSkillLevel() {
		return (endurance + sprint + dribble + passing + shooting) / 5.0;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("A name should not be empty.");
		}
		this.name = name;
	}

	private void setEndurance(int endurance) {
		checkStat("Endurance", endurance);
		this.endurance = endurance;
	}

	private void setSprint(int sprint) {
		checkStat("Sprint", sprint);
		this.sprint = sprint;
	}

	private void setDribble(int dribble) {
		checkStat("Dribble", dribble);
		this.dribble = dribble;
	}

	private void setPassing(int passing) {
		checkStat("Passing", passing);
		this.passing = passing;
	}

	private void setShooting(int shooting) {
		checkStat("Shooting", shooting);
		this.shooting = shooting;
	}

	private void checkStat(String statName, int stat) {
		if (stat < 0 || stat > 100) {
			throw new IllegalArgumentException(statName + " should be between 0 and 100.");
		}
	}
}
