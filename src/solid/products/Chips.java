package solid.products;

public class Chips extends DenseProduct implements Product {

	private static final double CALORIES_PER_100_GRAMS = 529.0;

	protected Chips(double grams) {
		super(grams);
	}

	@Override
	public double calculateCalories() {
		return 0;
	}
}
