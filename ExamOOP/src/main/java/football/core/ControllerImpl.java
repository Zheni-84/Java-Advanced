package football.core;

import football.common.ConstantMessages;
import football.common.ExceptionMessages;
import football.entities.field.ArtificialTurf;
import football.entities.field.Field;
import football.entities.field.NaturalGrass;
import football.entities.player.Men;
import football.entities.player.Player;
import football.entities.player.Women;
import football.entities.supplement.Liquid;
import football.entities.supplement.Powdered;
import football.entities.supplement.Supplement;
import football.repositories.SupplementRepository;
import football.repositories.SupplementRepositoryImpl;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

	private final SupplementRepository supplement;
	private final Map<String, Field> fields;

	public ControllerImpl() {
		this.supplement = new SupplementRepositoryImpl();
		this.fields = new LinkedHashMap<>();
	}

	@Override
	public String addField(String fieldType, String fieldName) {
		Field field;
		if (fieldType.equals("ArtificialTurf")) {
			field = new ArtificialTurf(fieldName);
		} else if (fieldType.equals("NaturalGrass")) {
			field = new NaturalGrass(fieldName);
		} else {
			throw new NullPointerException(ExceptionMessages.INVALID_FIELD_TYPE);
		}
		fields.put(fieldName, field);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FIELD_TYPE, fieldType);
	}

	@Override
	public String deliverySupplement(String type) {
		Supplement currentSupplement;
		if (type.equals("Powdered")) {
			currentSupplement = new Powdered();
		} else if (type.equals("Liquid")) {
			currentSupplement = new Liquid();
		} else {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_SUPPLEMENT_TYPE);
		}
		supplement.add(currentSupplement);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
	}

	@Override
	public String supplementForField(String fieldName, String supplementType) {
		Supplement currentSupplement = supplement.findByType(supplementType);
		if (currentSupplement == null) {
			throw new IllegalArgumentException(String.format(ExceptionMessages.NO_SUPPLEMENT_FOUND, supplementType));
		}

		Field field = fields.get(fieldName);
		field.addSupplement(currentSupplement);

		supplement.remove(currentSupplement);

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_SUPPLEMENT_IN_FIELD, supplementType, fieldName);
	}

	@Override
	public String addPlayer(String fieldName, String playerType, String playerName, String nationality, int strength) {
		Player player;
		if (playerType.equals("Men")) {
			player = new Men(playerName, nationality, strength);
		} else if (playerType.equals("Women")) {
			player = new Women(playerName, fieldName, strength);
		} else {
			throw new IllegalArgumentException(ExceptionMessages.INVALID_PLAYER_TYPE);
		}

		Field field = fields.get(fieldName);
		String fieldType = field.getClass().getSimpleName();
		boolean isWomenAndArtificialTurf = playerType.equals("Women") && fieldType.equals("ArtificialTurf");
		boolean isMenAndNaturalGrass = playerType.equals("Men") && fieldType.equals("NaturalGrass");

		if (isWomenAndArtificialTurf || isMenAndNaturalGrass) {
			field.addPlayer(player);
		} else {
			return ConstantMessages.FIELD_NOT_SUITABLE;
		}

		return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PLAYER_IN_FIELD, playerType, fieldName);
	}

	@Override
	public String dragPlayer(String fieldName) {
		Field field = fields.get(fieldName);
		field.drag();

		Collection<Player> playersDragged = field.getPlayers();

		return String.format(ConstantMessages.PLAYER_DRAG, playersDragged.size());
	}

	@Override
	public String calculateStrength(String fieldName) {
		Collection<Player> players = fields.get(fieldName).getPlayers();
		int playersStrengthSum = players.stream()
				.mapToInt(Player::getStrength)
				.sum();

		return String.format(ConstantMessages.STRENGTH_FIELD, fieldName, playersStrengthSum);
	}

	@Override
	public String getStatistics() {
		return fields.values().stream()
				.map(Field::getInfo)
				.collect(Collectors.joining(System.lineSeparator()))
				.trim()
				;
	}
}
