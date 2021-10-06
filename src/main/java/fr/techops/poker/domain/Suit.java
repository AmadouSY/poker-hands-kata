package fr.techops.poker.domain;

public enum Suit {
    SPADE,
    HEART,
    DIAMOND,
    CLUB;

    private final char letter;

    Suit() {
        this.letter = this.name().charAt(0);
    }

    public char getLetter() {
        return this.letter;
    }

    static public Suit of(char letter) {
        for (Suit s : Suit.values()) {
            if (s.letter == letter) {
                return s;
            }
        }
        return null;
    }
}