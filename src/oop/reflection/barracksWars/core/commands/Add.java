package oop.reflection.barracksWars.core.commands;

import jdk.jshell.spi.ExecutionControl;
import oop.reflection.barracksWars.annotations.Inject;
import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.Unit;
import oop.reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

	@Inject
	private Repository repository;
	@Inject
	private UnitFactory unitFactory;

	public Add(String[] data) {
		super(data);
	}

	@Override
	public String execute() throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException,
			NoSuchMethodException,
			InstantiationException,
			IllegalAccessException {
		final String unitType = super.getData()[1];
		final Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		return unitType + " added!";
	}
}
