package fr.techops.poker.domain;

public enum Rank {

    TWO('2', 2),
    THREE('3', 3),
    FOUR('4', 4),
    FIVE('5', 5),
    SIX('6', 6),
    SEVEN('7', 7),
    EIGHT('8', 8),
    NINE('9', 9),
    TEN('T', 10),
    JACK('J', 11),
    QUEEN('Q', 12),
    KING('K', 13),
    ACE('A', 14);

    private final char letter;
    private final int value;

    Rank(char letter, int value) {
        this.letter = letter;
        this.value = value;
    }

    public char getLetter() {
        return this.letter;
    }

    public int getValue() {
        return this.value;
    }

    static public Rank of(char letter) {
        for (Rank r : Rank.values()) {
            if (r.letter == letter) {
                return r;
            }
        }
        return null;
    }

}