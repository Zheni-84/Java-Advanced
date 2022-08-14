package glacialExpedition.models.explorers;

public class AnimalExplorer extends BaseExplorer{

	private static final double STARTING_ENERGY = 100.0;
	private static final double SEARCH_ENERGY = 7.0;

	public AnimalExplorer(String name) {
		super(name, STARTING_ENERGY);
	}

	@Override
	public void search() {
		super.search();
	}
}
