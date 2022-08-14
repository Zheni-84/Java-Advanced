package oop.reflection.barracksWars.core.commands;

import oop.reflection.barracksWars.annotations.Inject;
import oop.reflection.barracksWars.interfaces.Repository;

public class Retire extends Command {

	@Inject
	private Repository repository;

	public Retire(String[] data) {
		super(data);
	}

	@Override
	public String execute() throws IllegalArgumentException {
		final String unitType = super.getData()[1];
		this.repository.removeUnit(unitType);

		return unitType + " retired!";
	}
}
