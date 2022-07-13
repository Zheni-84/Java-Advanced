package oop.interfacesAndAbstraction.foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int numberOfPeople = Integer.parseInt(sc.nextLine());

		Map<String, Buyer> buyers = new HashMap<>();

		for (int i = 0; i < numberOfPeople; i++) {
			String input = sc.nextLine();
			String[] buyerParts = input.split(" ");
			String name = buyerParts[0];
			int age = Integer.parseInt(buyerParts[1]);
			Buyer buyer;
			if (buyerParts.length == 3) {
				buyer = new Rebel(name);
			} else {
				buyer = new Citizen(name);
			}
			buyers.put(name, buyer);
		}

		String buyerName = sc.nextLine();
		while (!"End".equals(buyerName)) {
			Buyer buyer = buyers.get(buyerName);

			if (buyer != null) {
				buyer.buyFood();
			}

			buyerName = sc.nextLine();
		}

		int tolalFood = buyers.values()
				.stream()
				.mapToInt(Buyer::getFood).sum();
		System.out.println(tolalFood);
	}
}
