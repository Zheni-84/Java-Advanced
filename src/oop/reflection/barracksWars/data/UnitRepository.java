package oop.reflection.barracksWars.data;

import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.Unit;

import java.util.Map;
import java.util.TreeMap;

public class UnitRepository implements Repository {

	private final Map<String, Integer> amountOfUnits;

	public UnitRepository() {
		this.amountOfUnits = new TreeMap<>();
	}

	public void addUnit(Unit unit) {
		String unitType = unit.getClass().getSimpleName();
		this.amountOfUnits.putIfAbsent(unitType, 0);

		int newAmount = this.amountOfUnits.get(unitType) + 1;
		this.amountOfUnits.put(unitType, newAmount);
	}

	public String getStatistics() {
		StringBuilder statBuilder = new StringBuilder();
		for (Map.Entry<String, Integer> entry : amountOfUnits.entrySet()) {
			String formatedEntry =
					String.format("%s -> %d%n", entry.getKey(), entry.getValue());
			statBuilder.append(formatedEntry);
		}
		statBuilder.setLength(
				statBuilder.length() - System.lineSeparator().length());

		return statBuilder.toString();
	}

	public void removeUnit(String unitType) throws IllegalArgumentException {
		if (this.amountOfUnits.containsKey(unitType) && this.amountOfUnits.get(unitType) != 0) {
			final Integer newAmountOfUnits = this.amountOfUnits.get(unitType) - 1;

			this.amountOfUnits.put(unitType, newAmountOfUnits);
		} else {
			throw new IllegalArgumentException("No such units in repository.");
		}

	}
}
