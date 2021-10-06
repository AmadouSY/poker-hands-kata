package fr.techops.poker.domain;

public class Card implements Comparable<Card> {

    private final Suit suit;
    private final Rank rank;

    private Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    static public Card of(String card) {
        if (card.length() != 2) {
            throw new IllegalArgumentException();
        }
        char rank = card.charAt(0);
        char suit = card.charAt(1);
        return new Card(Rank.of(rank), Suit.of(suit));
    }


    public Suit getSuit() {
        return suit;
    }


    public int value() {
        return rank.getValue();
    }

    @Override
    public int compareTo(Card card) {
        return this.value() - card.value();
    }

    @Override
    public String toString() {
        return String.valueOf(rank.getLetter()) + suit.getLetter();
    }

}

