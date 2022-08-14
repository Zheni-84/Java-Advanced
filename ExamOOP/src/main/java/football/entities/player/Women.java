package football.entities.player;

public class Women extends BasePlayer {

	//ONLY on ArtificialTurf !

	private static final double KG = 60.0;

	public Women(String name, String nationality, int strength) {
		super(name, nationality, strength);
		setKg(KG);
	}

	@Override
	public void stimulation() {
		setStrength(getStrength() + 115);
	}
}
