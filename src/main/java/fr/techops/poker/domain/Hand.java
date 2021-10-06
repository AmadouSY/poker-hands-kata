package fr.techops.poker.domain;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
public class Hand implements Comparable<Hand>{

    private final List<Card> cards;
    private final HandValue value;

    public Hand(List<Card> cards) {
        this.cards = cards.stream().sorted().collect(Collectors.toList());
        this.value = calculateValue();
    }

    public static Hand of(String hand){
        List<Card> cards = new ArrayList<>();
        for(String card : hand.split(" ")){
            cards.add(Card.of(card));
        }
        return new Hand(cards);
    }

    private HandValue calculateValue(){

        if (isStraight() && isFlush()) {
            return HandValue.STRAIGHT_FLUSH;
        }

        if (isFourOfAKind()) {
            return HandValue.FOUR_OF_A_KIND;
        }

        if (isFullHouse()) {
            return HandValue.FULL_HOUSE;
        }

        if (isFlush()) {
            return HandValue.FLUSH;
        }
        if (isStraight()) {
            return HandValue.STRAIGHT;
        }

        if (isThreeOfAKind()) {
            return HandValue.THREE_OF_A_KIND;
        }

        if (isTwoPair()) {
            return HandValue.TWO_PAIRS;
        }

        if (isPair()) {
            return HandValue.PAIR;
        }

        return HandValue.HIGH_CARD;
    }


    private boolean isStraight() {
        int value = cards.get(0).value();

        for (int i = 1; i < cards.size(); i++) {
            Card card = cards.get(i);

            if (card.value() != value + 1) {
                return false;
            }
            value = card.value();
        }
        return true;
    }

    private boolean isFlush() {

        Suit value = cards.get(0).getSuit();

        for (int i = 1; i < cards.size(); i++) {
            Card card = cards.get(i);

            if (card.getSuit() != value) {
                return false;
            }

        }
        return true;
    }

    private boolean isFullHouse(){
        Map<Integer, Long> collect = cards.stream().collect(Collectors.groupingBy(Card::value, Collectors.counting()));
        return collect.containsValue(3L) && collect.containsValue(2L);
    }

    private boolean isFourOfAKind(){
        Map<Integer, Long> collect = cards.stream().collect(Collectors.groupingBy(Card::value, Collectors.counting()));
        return collect.containsValue(4L);
    }

    private boolean isThreeOfAKind(){
        Map<Integer, Long> collect = cards.stream().collect(Collectors.groupingBy(Card::value, Collectors.counting()));
        return collect.containsValue(3L);
    }

    private boolean isTwoPair(){
        Map<Integer, Long> collect = cards.stream().collect(Collectors.groupingBy(Card::value, Collectors.counting()));
        return collect.containsValue(2L) && collect.size() == 3 && collect.containsValue(1L);
    }

    private boolean isPair() {
        Map<Integer, Long> collect = cards.stream().collect(Collectors.groupingBy(Card::value, Collectors.counting()));
        return collect.containsValue(2L);
    }

    @Override
    public int compareTo(Hand hand) {
        return this.calculateValue().getValue() - hand.calculateValue().getValue();
    }

    public int getHighestCard() {
        return cards.get(4).value();
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
