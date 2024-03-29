package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepository;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

	private FoodRepository foodRepository;
	private Map<String, Area> areas;

	public ControllerImpl() {
		this.foodRepository = new FoodRepositoryImpl();
		this.areas = new LinkedHashMap<>();
	}

	@Override
	public String addArea(String areaType, String areaName) {
		Area area;
		if (areaType.equals("WaterArea")) {
			area = new WaterArea(areaName);
		} else if (areaType.equals("LandArea")) {
			area = new LandArea(areaName);
		} else {
			throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
		}
		areas.put(areaName, area);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
	}

	@Override
	public String buyFood(String foodType) {
		Food food;
		if (foodType.equals("Vegetable")) {
			food = new Vegetable();
		} else if (foodType.equals("Meat")) {
			food = new Meat();
		} else {
			throw new NullPointerException(ExceptionMessages.INVALID_FOOD_TYPE);
		}
		foodRepository.add(food);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, foodType);
	}

	@Override
	public String foodForArea(String areaName, String foodType) {
		Food food = foodRepository.findByType(foodType);
		if (food == null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND, foodType));
		}

		Area area = areas.get(areaName);
		area.addFood(food);

		foodRepository.remove(food);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA, foodType, areaName);
	}

	@Override
	public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
		Animal animal;
		if (animalType.equals("TerrestrialAnimal")) {
			animal = new TerrestrialAnimal(animalName, kind, price);
		} else if (animalType.equals("AquaticAnimal")) {
			animal = new AquaticAnimal(animalName, kind, price);
		} else {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
		}

		Area area = areas.get(areaName);
		String areaType = area.getClass().getSimpleName();
		boolean isLandBased = areaType.equals("LandArea") && animalType.equals("TerrestrialAnimal");
		boolean isWaterBased = areaType.equals("WaterArea") && animalType.equals("AquaticAnimal");

		if (isLandBased || isWaterBased) {
			area.addAnimal(animal);
		} else {
			return ConstantMessages.AREA_NOT_SUITABLE;
		}
		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
	}

	@Override
	public String feedAnimal(String areaName) {
		Area area = areas.get(areaName);
		area.feed();

		return String.format(ConstantMessages.ANIMALS_FED, area.getAnimals().size());
	}

	@Override
	public String calculateKg(String areaName) {
		Collection<Animal> animals = areas.get(areaName).getAnimals();
		double kgs = animals.stream().mapToDouble(Animal::getKg).sum();

		return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, kgs);
	}

	@Override
	public String getStatistics() {
		return areas.values().stream()
				.map(Area::getInfo)
				.collect(Collectors.joining(System.lineSeparator()))
				//.trim()
				;
	}
}
