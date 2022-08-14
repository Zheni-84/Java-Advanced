package football.entities.player;

public class Men extends BasePlayer{

	//ONLY on NaturalGrass !

	private static final double KG = 85.50;

	public Men(String name, String nationality, int strength) {
		super(name, nationality, strength);
		setKg(KG);
	}

	@Override
	public void stimulation() {
		this.setStrength(this.getStrength() + 145);
	}
}
