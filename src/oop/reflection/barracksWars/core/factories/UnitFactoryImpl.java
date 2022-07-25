package oop.reflection.barracksWars.core.factories;

import oop.reflection.barracksWars.interfaces.Unit;
import oop.reflection.barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME = "oop.reflection.barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ExecutionControl.NotImplementedException,
			ClassNotFoundException,
			InvocationTargetException,
			NoSuchMethodException,
			InstantiationException,
			IllegalAccessException {
		final Class<Unit> unitClass = (Class<Unit>) Class.forName(UNITS_PACKAGE_NAME + unitType);

		return createUnit(unitClass);
	}

	private Unit createUnit(Class<Unit> unitClass)
			throws NoSuchMethodException,
			InvocationTargetException,
			InstantiationException,
			IllegalAccessException {
		Constructor<Unit> declaredConstructor = unitClass.getDeclaredConstructor();
		declaredConstructor.setAccessible(true);

		return declaredConstructor.newInstance();
	}

}
