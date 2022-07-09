package oop.workingWithAbstraction.cardsWithPower;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		CardRanks cardRank = CardRanks.valueOf(sc.nextLine());
		CardSuits cardSuit = CardSuits.valueOf(sc.nextLine());

		CardsWithPower card = new CardsWithPower(cardSuit, cardRank);
		System.out.printf("Card name: %s of %s; Card power: %d%n", card.getCardRanks(), card.getCardSuits(), card.getPower());
	}
}
