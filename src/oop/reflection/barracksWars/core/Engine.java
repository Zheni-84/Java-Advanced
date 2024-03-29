package oop.reflection.barracksWars.core;

import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.Runnable;
import oop.reflection.barracksWars.interfaces.Unit;
import oop.reflection.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | ExecutionControl.NotImplementedException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (InstantiationException e) {
				throw new RuntimeException(e);
			} catch (IllegalAccessException e) {
				throw new RuntimeException(e);
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName)
			throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException, NoSuchMethodException,
			InstantiationException,
			IllegalAccessException {
		String result;
		switch (commandName) {
			case "add":
				result = this.addUnitCommand(data);
				break;
			case "report":
				result = this.reportCommand(data);
				break;
			case "fight":
				result = this.fightCommand(data);
				break;
			case "retire":
				result = this.retireCommand(data);
				break;
			default:
				throw new RuntimeException("Invalid command!");
		}
		return result;
	}

	private String reportCommand(String[] data) {
		return this.repository.getStatistics();
	}

	private String addUnitCommand(String[] data)
			throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException,
			NoSuchMethodException,
			InstantiationException, IllegalAccessException {
		String unitType = data[1];
		Unit unitToAdd = this.unitFactory.createUnit(unitType);
		this.repository.addUnit(unitToAdd);
		return unitType + " added!";
	}
	
	private String fightCommand(String[] data) {
		return "fight";
	}

	private String retireCommand(String[] data) throws IllegalArgumentException {
		final String unitType = data[1];
		this.repository.removeUnit(unitType);

		return unitType + " retired!";
	}
}
