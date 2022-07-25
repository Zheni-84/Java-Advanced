package solid.products;

public abstract class LiquidProduct{

	private final double milliliters;

	protected LiquidProduct(double milliliters) {
		this.milliliters = milliliters;
	}

	public double getMilliliters() {
		return milliliters;
	}

}
