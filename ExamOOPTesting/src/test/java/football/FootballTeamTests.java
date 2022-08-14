package football;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FootballTeamTests {

	public static final String CSKA = "CSKA";
	public static final String PETROV = "Petrov";
	public static final String ZARKOV = "Zarkov";
	public static final String STOICHKOV = "Stoichkov";
	public static final int VACANT_POSITIONS = 10;

	private FootballTeam footballTeam;
	private Footballer footballer1;
	private Footballer footballer2;
	private Footballer footballer3;

	@Before
	public void init() {
		this.footballTeam = new FootballTeam(CSKA, VACANT_POSITIONS);
		this.footballer1 = new Footballer(PETROV);
		this.footballer2 = new Footballer(ZARKOV);
		this.footballer3 = new Footballer(STOICHKOV);
	}

	@Test
	public void test_getName_ShouldReturnName() {
		assertEquals(CSKA, footballTeam.getName());
	}

	@Test(expected = NullPointerException.class)
	public void test_FootballTeam_ShouldThrowForNullName() {
		new FootballTeam(null, VACANT_POSITIONS);
	}

	@Test(expected = NullPointerException.class)
	public void test_FootballTeam_ShouldThrowForEmptyName() {
		new FootballTeam("   ", VACANT_POSITIONS);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_FootballTeam_ShouldThrowWithNegativeVacantPositions() {
		new FootballTeam(CSKA, -10);
	}

	@Test
	public void test_getVacantPositions_ShouldReturnPositions() {
		int actual = footballTeam.getVacantPositions();
		assertEquals(VACANT_POSITIONS, actual);
	}

	@Test
	public void test_getCount_ShouldReturnCount() {
		footballTeam.addFootballer(footballer1);
		footballTeam.addFootballer(footballer2);
		footballTeam.addFootballer(footballer3);
		assertEquals(3, footballTeam.getCount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addFootballer_ShouldThrowWhenNoVacantPositionsAreLeft() {
		FootballTeam footballTeam1 = new FootballTeam(CSKA, 2);
		footballTeam1.addFootballer(footballer1);
		footballTeam1.addFootballer(footballer2);
		footballTeam1.addFootballer(footballer3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_removeFootballer_ShouldThrowIfFootballerNotInTheList() {
		footballTeam.removeFootballer("Avramova");
	}

	@Test
	public void test_removeFootballer_ShouldRemoveFootballer() {
		footballTeam.addFootballer(footballer1);
		footballTeam.addFootballer(footballer2);
		footballTeam.addFootballer(footballer3);

		footballTeam.removeFootballer(footballer3.getName());
		assertEquals(2, footballTeam.getCount());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_footballerForSale_ShouldThrowIfFootballerNotInTheList() {
		footballTeam.footballerForSale("Avramova");
	}

	@Test
	public void test_footballerForSale_ShouldSetAndReturnNotActiveFootballer() {
		footballTeam.addFootballer(footballer1);
		footballTeam.addFootballer(footballer2);
		footballTeam.addFootballer(footballer3);

		Footballer notActiveOne = footballTeam.footballerForSale(footballer3.getName());
		assertFalse(notActiveOne.isActive());
	}

	@Test
	public void test_getStatistics_ShouldReturnString() {
		String expected = String.format("The footballer %s is in the team %s.", PETROV, CSKA);
		footballTeam.addFootballer(footballer1);
		String actual = footballTeam.getStatistics();
		assertEquals(expected, actual);
	}
}
