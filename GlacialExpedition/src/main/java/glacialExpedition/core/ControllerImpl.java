package glacialExpedition.core;

import glacialExpedition.common.ConstantMessages;
import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.models.explorers.AnimalExplorer;
import glacialExpedition.models.explorers.Explorer;
import glacialExpedition.models.explorers.GlacierExplorer;
import glacialExpedition.models.explorers.NaturalExplorer;
import glacialExpedition.models.mission.Mission;
import glacialExpedition.models.mission.MissionImpl;
import glacialExpedition.models.states.State;
import glacialExpedition.models.states.StateImpl;
import glacialExpedition.repositories.ExplorerRepository;
import glacialExpedition.repositories.StateRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

	private ExplorerRepository explorerRepository;
	private StateRepository stateRepository;
	private int exploredSates;

	public ControllerImpl() {
		this.explorerRepository = new ExplorerRepository();
		this.stateRepository = new StateRepository();
		this.exploredSates = 0;
	}

	@Override
	public String addExplorer(String type, String explorerName) {
		Explorer explorer;
		switch (type) {
			case "AnimalExplorer":
				explorer = new AnimalExplorer(explorerName);
				break;
			case "GlacierExplorer":
				explorer = new GlacierExplorer(explorerName);
				break;
			case "NaturalExplorer":
				explorer = new NaturalExplorer(explorerName);
				break;
			default:
				throw new IllegalArgumentException(ExceptionMessages.EXPLORER_INVALID_TYPE);
		}
		explorerRepository.add(explorer);
		return String.format(ConstantMessages.EXPLORER_ADDED, type, explorerName);
	}

	@Override
	public String addState(String stateName, String... exhibits) {
		StateImpl state = new StateImpl(stateName);
		Collections.addAll(state.getExhibits(), exhibits);
		stateRepository.add(state);
		return String.format(ConstantMessages.STATE_ADDED, stateName);
	}

	@Override
	public String retireExplorer(String explorerName) {
		Explorer explorerToRemove = explorerRepository.byName(explorerName);
		if (explorerToRemove == null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.EXPLORER_DOES_NOT_EXIST, explorerName));
		}
		explorerRepository.remove(explorerToRemove);

		return String.format(ConstantMessages.EXPLORER_RETIRED, explorerName);
	}

	@Override
	public String exploreState(String stateName) {
		List<Explorer> validExplorers = explorerRepository.getCollection().stream()
				.filter(e -> e.getEnergy() > 50)
				.collect(Collectors.toList());
		if (validExplorers.isEmpty()) {
			throw new IllegalArgumentException(ExceptionMessages.STATE_EXPLORERS_DOES_NOT_EXISTS);
		}
		State state = stateRepository.byName(stateName);
		Mission mission = new MissionImpl();
		mission.explore(state, validExplorers);
		exploredSates++;
		long countOfTiredExplorers = validExplorers.stream().filter(e -> e.getEnergy() == 0).count();
		return String.format(ConstantMessages.STATE_EXPLORER, stateName, countOfTiredExplorers);
	}

	@Override
	public String finalResult() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format(ConstantMessages.FINAL_STATE_EXPLORED, exploredSates));
		sb.append(System.lineSeparator());
		sb.append(ConstantMessages.FINAL_EXPLORER_INFO);
		sb.append(System.lineSeparator());
		sb.append(explorerRepository.toString());

		return sb.toString().trim();
	}
}
