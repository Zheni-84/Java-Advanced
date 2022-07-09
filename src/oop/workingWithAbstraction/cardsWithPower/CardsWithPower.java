package oop.workingWithAbstraction.cardsWithPower;

public class CardsWithPower {

	private CardSuits cardSuits;
	private CardRanks cardRanks;

	public CardsWithPower(CardSuits cardSuits, CardRanks cardRanks) {
		this.cardSuits = cardSuits;
		this.cardRanks = cardRanks;
	}

	public int getPower() {
		return cardSuits.getSuitPower() + cardRanks.getRankPower();
	}

	public CardSuits getCardSuits() {
		return cardSuits;
	}

	public CardRanks getCardRanks() {
		return cardRanks;
	}
}
