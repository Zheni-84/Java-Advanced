package oop.reflection.barracksWars.core.commands;

import oop.reflection.barracksWars.annotations.Inject;
import oop.reflection.barracksWars.interfaces.Executable;
import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.UnitFactory;

public abstract class Command implements Executable {

	private final String[] data;

	public Command(String[] data) {
		this.data = data;
	}

	public String[] getData() {
		return this.data;
	}
}

