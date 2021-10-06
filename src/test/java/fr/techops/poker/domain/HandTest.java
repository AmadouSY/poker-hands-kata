package fr.techops.poker.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HandTest {

    @Test
    void should_return_flush_when_all_the_card_have_the_same_suit(){
        Hand hand = Hand.of("JH AH 4H 5H JH");
        assertThat(hand.getValue()).isEqualTo(HandValue.FLUSH);
    }

    @Test
    void should_return_straight_when_the_cards_are_consecutive(){
        Hand hand = Hand.of("2H 6D 4H 5C 3S");
        assertThat(hand.getValue()).isEqualTo(HandValue.STRAIGHT);
    }

    @Test
    void should_return_full_house_when_3_cards_are_the_same_and_a_pair(){
        Hand hand = Hand.of("2H 2S 3H 3J 3S");
        assertThat(hand.getValue()).isEqualTo(HandValue.FULL_HOUSE);
    }

    @Test
    void should_return_three_of_a_kind_when_3_have_the_same_Rank(){
        Hand hand = Hand.of("2H 5S 3H 3J 3S");
        assertThat(hand.getValue()).isEqualTo(HandValue.THREE_OF_A_KIND);
    }

    @Test
    void should_return_two_paris_when_the_hand_contains_two_pairs(){
        Hand hand = Hand.of("2H 2S 7H 3J 3S");
        assertThat(hand.getValue()).isEqualTo(HandValue.TWO_PAIRS);
    }
    @Test
    void should_return_pair_when_2_cards_have_the_same_Rank(){
        Hand hand = Hand.of("2H 2S 7H 4J 3S");
        assertThat(hand.getValue()).isEqualTo(HandValue.PAIR);
    }

    @Test
    void should_return_high_card_when_the_hand_dont_fit_in_any_other_category(){
        Hand hand = Hand.of("2H 6S JC 5D KH");
        assertThat(hand.getValue()).isEqualTo(HandValue.HIGH_CARD);
    }

    @Test
    void should_return_straight_flush_when_straight_and_flush(){
        Hand hand = Hand.of("2H 6H 4H 5H 3H");
        assertThat(hand.getValue()).isEqualTo(HandValue.STRAIGHT_FLUSH);
    }
    @Test
    void highest_hand(){
        Hand hand = Hand.of("AC 6H 4H 5H 3H");
        assertThat(hand.getHighestCard()).isEqualTo(Rank.ACE.getValue());
    }
}