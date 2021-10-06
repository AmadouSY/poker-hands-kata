import fr.techops.poker.domain.Card;
import fr.techops.poker.domain.Hand;
import fr.techops.poker.domain.HandValue;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Poker {

    Hand black;
    Hand white;

    public Poker(String black, String white){
        this.black = Hand.of(black);
        this.white = Hand.of(white);
    }

    public String game(){
        HandValue blackValue = black.getValue();
        HandValue whiteValue = white.getValue();

        if(blackValue == whiteValue){
            return getWinner(black.getHighestCard(), white.getHighestCard());
        }
        return getWinner(blackValue.getValue(), whiteValue.getValue());
    }


    private String getWinner(int black, int white) {
        if(black > white){
            return "Black wins with " + black;
        }

        if(white > black){
            return "White wins with " + white;
        }

        return "Tie";
    }

    class PokerResult{

        String winner;
        Card card;


    }
}
