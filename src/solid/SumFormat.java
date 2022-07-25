package solid;

public class SumFormat implements Format<Double>{
	private static final String SUM = "Sum: %f";

	@Override
	public String format(Double calculationResult) {
		return String.format((SUM), calculationResult);
	}
}
