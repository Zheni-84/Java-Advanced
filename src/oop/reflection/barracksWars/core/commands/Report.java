package oop.reflection.barracksWars.core.commands;

import oop.reflection.barracksWars.annotations.Inject;
import oop.reflection.barracksWars.interfaces.Repository;
import oop.reflection.barracksWars.interfaces.UnitFactory;

public class Report extends Command {

	@Inject
	private Repository repository;

	public Report(String[] data) {
		super(data);
	}

	@Override
	public String execute() {
		return this.repository.getStatistics();
	}
}
