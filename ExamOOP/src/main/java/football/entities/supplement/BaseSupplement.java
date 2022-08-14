package football.entities.supplement;

public abstract class BaseSupplement implements Supplement{

	private final int energy;
	private final double price;

	protected BaseSupplement(int energy, double price) {
		this.energy = energy;
		this.price = price;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public double getPrice() {
		return price;
	}
}
