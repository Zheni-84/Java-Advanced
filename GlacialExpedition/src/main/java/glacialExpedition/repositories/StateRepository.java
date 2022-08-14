package glacialExpedition.repositories;

import glacialExpedition.models.states.State;

import java.util.*;

public class StateRepository implements Repository<State> {

	private final Map<String, State> states;

	public StateRepository() {
		this.states = new LinkedHashMap<>();
	}

	@Override
	public Collection<State> getCollection() {
		return Collections.unmodifiableCollection(states.values());
	}

	@Override
	public void add(State entity) {
		states.put(entity.getName(), entity);
	}

	@Override
	public boolean remove(State entity) {
		return Objects.nonNull(states.remove(entity.getName()));
	}

	@Override
	public State byName(String name) {
		return states.get(name);
	}
}
