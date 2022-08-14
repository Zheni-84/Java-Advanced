package glacialExpedition.models.explorers;

public class NaturalExplorer extends BaseExplorer{

	private static final double STARTING_ENERGY = 60.0;
	private static final double SEARCH_ENERGY = 7.0;

	public NaturalExplorer(String name) {
		super(name, STARTING_ENERGY);
	}

	@Override
	public void search() {
		setEnergy(Math.max(0, getEnergy() - SEARCH_ENERGY));
	}
}
