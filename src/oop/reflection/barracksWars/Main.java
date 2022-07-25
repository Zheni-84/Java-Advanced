package oop.reflection.barracksWars;

import oop.reflection.barracksWars.core.Engine;
import oop.reflection.barracksWars.core.factories.UnitFactoryImpl;
import oop.reflection.barracksWars.data.UnitRepository;
import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.Runnable;
import oop.reflection.barracksWars.interfaces.UnitFactory;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
