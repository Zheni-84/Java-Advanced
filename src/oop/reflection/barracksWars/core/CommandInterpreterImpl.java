package oop.reflection.barracksWars.core;

import oop.reflection.barracksWars.interfaces.CommandInterpreter;
import oop.reflection.barracksWars.interfaces.Executable;
import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;

public class CommandInterpreterImpl implements CommandInterpreter {

	private static final String COMMAND_PACKAGE = "oop.reflection.barracksWars.core.commands.";

	private final Repository repository;
	private final UnitFactory unitFactory;

	public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	@SuppressWarnings("all")
	public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException,
			NoSuchMethodException {
		String finalCommandName = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

		Class<? extends Executable> commandClass =
				(Class<? extends Executable>) Class.forName(COMMAND_PACKAGE + finalCommandName);
		Constructor<? extends Executable> declaredConstructor =
				commandClass.getDeclaredConstructor(String[].class);
		declaredConstructor.setAccessible(true);


		return null;
	}
}
