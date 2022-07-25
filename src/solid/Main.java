package solid;

import solid.products.Coke;
import solid.products.LiquidProduct;

public class Main {

    public static void main(String[] args) {

        Format<Double> sumFormat = new SumFormat();
        PrinterDouble printer = new PrinterDouble(sumFormat);
        printer.print(201.0);
        System.out.println();

        Coke coke = new Coke(550.0);
        System.out.println(coke.calculateCalories());

    }
}
