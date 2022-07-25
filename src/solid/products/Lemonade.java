package solid.products;

public class Lemonade extends LiquidProduct implements Product{

    public static final double CALORIES_PER_100_GRAMS = 53.0;
    public static final double DENSITY = 0.7;

    protected Lemonade(double milliliters) {
        super(milliliters);
    }

    @Override
    public double calculateCalories() {

        double grams = this.getMilliliters() * DENSITY;

        return (CALORIES_PER_100_GRAMS / 100) * grams;
    }
}
