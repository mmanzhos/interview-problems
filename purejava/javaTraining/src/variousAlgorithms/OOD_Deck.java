package variousAlgorithms;


class Deck {
	
	Card[] cards;
	
	public Deck() {
		fillDeck();
	}

	private void fillDeck() {
		cards = new Card[52];
		int iterator = 0;
		for (int i = 1; i <= 13; i++) {
			for (int j = 1; j <= 4; j++) {
				cards[iterator++] = new BlackJackCard(CardName.getCardName(i), Suit.getSuit(j));
			}
		}
	}
	
	public void outputDeck() {
		for (Card card : cards) {
			System.out.println(card.getSuit() + " " + card.getName());
		}
	}
	
}

enum Suit {
	CLUBS (1),
	SPADES (2),
	HEARTS (3),
	DIAMONDS (4);
	int value;
	Suit(int v) {
		value = v;
	}
	
	public static Suit getSuit(int v) {
		for (Suit n : Suit.values()) {
			if (n.value == v)
				return n;
		}
		return null;
	}
}

enum CardName {
	ACE (1),
	TWO (2),
	THREE (3),
	FOUR (4),
	FIVE (5),
	SIX (6),
	SEVEN (7),
	EIGHT (8),
	NINE (9),
	TEN (10),
	JACK (11),
	QUEEN (12),
	KING (13);
	int value;
	private CardName(int v) {
		value = v;
	}
	
	public static CardName getCardName(int v) {
		for (CardName n : CardName.values()) {
			if (n.value == v)
				return n;
		}
		return null;
	}
	
}

class Card {
	
	
	protected int value;
	private Suit suit;
	private CardName name;
	
	
	public Card(CardName name, Suit suit) {
		this.suit = suit;
		this.name = name;
		this.value = name.value;
	}
	
	public CardName getName() {
		return name;
	}

	public Suit getSuit() {
		return suit;
	}

	public int getValue() {
		return value;
	}
	
}

class BlackJackCard extends Card {

	public BlackJackCard(CardName name, Suit suit) {
		super(name, suit);
		value = valueCheck(value);
	}
	
	private int valueCheck(int value) {
		switch (value) {
			case 1:
				value = 11;
				break;
			case 2:
				value = 10;
				break;
			default:
				break;
		}
		return value;
	}
	
}


public class OOD_Deck {
	
	public static void main(String[] args) {
		
		Deck deck = new Deck();
		deck.outputDeck();
	}
	
}
