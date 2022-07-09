package oop.encapsulation.pizzaCalories;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] pizzaData = sc.nextLine().split(" ");
		String pizzaName = pizzaData[1];
		int numberOfToppings = Integer.parseInt(pizzaData[2]);

		String[] doughData = sc.nextLine().split(" ");
		String flourType = doughData[1];
		String bakingTechnique = doughData[2];
		double doughWeight = Double.parseDouble(doughData[3]);

		try {
			Pizza pizza = new Pizza(pizzaName, numberOfToppings);
			Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
			pizza.setDough(dough);

			String toppingData = sc.nextLine();
			while (!"END".equals(toppingData)) {
				String[] toppingInfo = toppingData.split(" ");
				String toppingType = toppingInfo[1];
				double toppingWight = Double.parseDouble(toppingInfo[2]);
				Topping topping = new Topping(toppingType, toppingWight);
				pizza.addTopping(topping);

				toppingData = sc.nextLine();
			}
			System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}

	}

}
