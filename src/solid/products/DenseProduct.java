package solid.products;

public abstract class DenseProduct {

	private final double grams;

	protected DenseProduct(double grams) {
		this.grams = grams;
	}

	public double getGrams() {
		return grams;
	}
}
