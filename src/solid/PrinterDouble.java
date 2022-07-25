package solid;

public class PrinterDouble implements Printer<Double>{

	private Format<Double> formatter;

	public PrinterDouble(Format<Double> format) {
		this.formatter = format;
	}

	@Override
	public void print(Double amount) {
		System.out.printf(formatter.format(amount));
	}

	//	public void printSum(List<Object> products) {
	//		System.out.printf((SUM) + "%n", sum(products));
	//	}
	//
	//	public void printAverage(List<Object> products) {
	//		System.out.printf((AVERAGE) + "%n", average(products));
	//	}

}
