package oop.workingWithAbstraction.cards;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("Card Suits:");

		Arrays.stream(Cards.values())
				.forEach(cards -> System.out.printf("Ordinal value: %d; Name value: %s%n", cards.ordinal(), cards.name()));
	}

}
