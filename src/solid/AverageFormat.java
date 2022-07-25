package solid;

public class AverageFormat implements Format<Double> {

	private static final String AVERAGE = "Average: %f";

	@Override
	public String format(Double calculationResult) {
		return String.format((AVERAGE), calculationResult);
	}
}
