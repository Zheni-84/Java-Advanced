package oop.workingWithAbstraction.cardRanks;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		System.out.println("Card Ranks:");

		Arrays.stream(CardRanks.values())
				.forEach(cards -> System.out.printf("Ordinal value: %d; Name value: %s%n", cards.ordinal(), cards.name()));

	}
}
