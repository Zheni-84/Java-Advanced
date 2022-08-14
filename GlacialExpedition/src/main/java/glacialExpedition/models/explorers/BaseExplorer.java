package glacialExpedition.models.explorers;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.suitcases.Carton;
import glacialExpedition.models.suitcases.Suitcase;

public abstract class BaseExplorer implements Explorer {

	private static final int SEARCH_ENERGY = 15;

	private String name;
	private double energy;
	private final Suitcase suitcase;

	protected BaseExplorer(String name, double energy) {
		setName(name);
		setEnergy(energy);
		this.suitcase = new Carton();
	}

	protected void setName(String name) {
		if (name == null || name.trim().isEmpty()) {
			throw new NullPointerException(ExceptionMessages.EXPLORER_NAME_NULL_OR_EMPTY);
		}
		this.name = name;
	}

	protected void setEnergy(double energy) {
		if (energy < 0) {
			throw new NullPointerException(ExceptionMessages.EXPLORER_ENERGY_LESS_THAN_ZERO);
		}
		this.energy = energy;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getEnergy() {
		return this.energy;
	}

	@Override
	public boolean canSearch() {
		return this.energy > 0;
	}

	@Override
	public Suitcase getSuitcase() {
		return this.suitcase;
	}

	@Override
	public void search() {
		this.energy = Math.max(0, energy - SEARCH_ENERGY);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(ConstantMessages.FINAL_EXPLORER_NAME, getName()));
		sb.append(System.lineSeparator());
		sb.append(String.format(ConstantMessages.FINAL_EXPLORER_ENERGY, getEnergy()));
		sb.append(System.lineSeparator());
		if (getSuitcase().getExhibits().isEmpty()) {
			sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS, "None"));
		} else {
			sb.append(String.format(ConstantMessages.FINAL_EXPLORER_SUITCASE_EXHIBITS,
					String.join(ConstantMessages.DELIMITER, getSuitcase().getExhibits())));

		}

		return sb.toString().trim();
	}
}
