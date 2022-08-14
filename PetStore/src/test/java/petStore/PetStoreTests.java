package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {

	private static final String SPECIE = "Dog";
	private static final int MAX_WEIGHT = 30;
	private static final double PRICE = 100.00;

	private PetStore petStore;
	private Animal animal;

	@Before
	public void setUp() {
		this.petStore = new PetStore();
		this.animal = new Animal(SPECIE, MAX_WEIGHT, PRICE);
	}

	@Test(expected = UnsupportedOperationException.class)
	public void test_getAnimalsShouldReturn_UnmodifiableList() {
		List<Animal> animals = petStore.getAnimals();
		animals.remove(1);
	}

	@Test
	public void test_getCountShouldReturnZero_WhenEmpty_AndOneWhenSingleAnimalAdded() {
		assertEquals(0, petStore.getCount());
		petStore.addAnimal(animal);
		assertEquals(1, petStore.getCount());
	}

	@Test
	public void test_findAllAnimalsWithMaxKilograms_ShouldReturnEmptyWhenNoSuchAnimals() {
		petStore.addAnimal(animal);
		List<Animal> allAnimalsWithMaxKilograms = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT + 10);
		assertTrue(allAnimalsWithMaxKilograms.isEmpty());
	}

	@Test
	public void test_findAllAnimalsWithMaxKilograms_ShouldReturnOnlyHeavierAnimals() {
		petStore.addAnimal(animal);
		petStore.addAnimal(new Animal("test", MAX_WEIGHT - 2, PRICE));
		List<Animal> animals = petStore.findAllAnimalsWithMaxKilograms(MAX_WEIGHT - 1);
		assertEquals(1, animals.size());
		assertEquals(animal.getSpecie(), animals.get(0).getSpecie());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_addAnimal_ShouldThrowWhenAnimal_IsNull() {
		petStore.addAnimal(null);
	}

	@Test
	public void test_addAnimal_ShouldIncreaseCount() {
		petStore.addAnimal(animal);
		assertEquals(1, petStore.getCount());
	}

	@Test
	public void test_getTheMostExpensiveAnimal_ShouldReturnNullWhenEmpty() {
		Animal animal1 = petStore.getTheMostExpensiveAnimal();
		assertNull(animal1);
	}

	@Test
	public void test_getTheMostExpensiveAnimal_ShouldReturn_TheMostExpensiveOne() {
		petStore.addAnimal(animal);
		petStore.addAnimal(new Animal("test", MAX_WEIGHT, PRICE - 10));
		Animal actualAnimal = petStore.getTheMostExpensiveAnimal();
		assertEquals(animal.getPrice(), actualAnimal.getPrice(), 0.0);
	}

	@Test
	public void test_findAllAnimalBySpecie_ShouldReturnEmptyListWhenNoAnimals() {
		List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
		assertTrue(animals.isEmpty());
	}

	@Test
	public void test_findAllAnimalBySpecie_ShouldReturnOnlyTheProvidedSpecie() {
		petStore.addAnimal(animal);
		petStore.addAnimal(new Animal("Goat", MAX_WEIGHT, PRICE));
		List<Animal> animals = petStore.findAllAnimalBySpecie(SPECIE);
		assertEquals(1, animals.size());
		assertEquals(SPECIE, animals.get(0).getSpecie());
	}
}

