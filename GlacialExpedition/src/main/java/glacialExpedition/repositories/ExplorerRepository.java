package glacialExpedition.repositories;

import glacialExpedition.models.explorers.Explorer;

import java.util.*;

public class ExplorerRepository implements Repository<Explorer> {

	private final Map<String, Explorer> explorers;

	public ExplorerRepository() {
		this.explorers = new LinkedHashMap<>();
	}

	@Override
	public Collection<Explorer> getCollection() {
		return Collections.unmodifiableCollection(explorers.values());
	}

	@Override
	public void add(Explorer entity) {
		explorers.put(entity.getName(), entity);
	}

	@Override
	public boolean remove(Explorer entity) {
		return Objects.nonNull(explorers.remove(entity.getName()));
	}

	@Override
	public Explorer byName(String name) {
		return explorers.get(name);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		explorers.values().forEach(e -> sb.append(e).append(System.lineSeparator()));
		return sb.toString().trim();
	}
}
