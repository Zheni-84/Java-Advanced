package solid;

import solid.products.Chocolate;
import solid.products.Coke;
import solid.products.Lemonade;
import solid.products.Product;

import java.util.List;

public class CalorieCalculatorImpl implements CalorieCalculator {

	private final List<Product> products;

	public CalorieCalculatorImpl(List<Product> products) {
		this.products = products;
	}

	@Override
	public Double sum() {

		return products.stream()
				.map(Product::calculateCalories)
				.reduce(0.0, Double::sum);
	}

	@Override
	public Double average() {
		return this.sum() / products.size();
	}

}
