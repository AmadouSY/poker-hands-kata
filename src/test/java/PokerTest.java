import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PokerTest {

    Poker poker;

    @Test
    void black_wins() {
        poker = new Poker("2H 4S 4C 2D 4H", "2S 8S AS QS 3S");
        assertThat(poker.game()).contains("Black");
    }

    @Test
    void white_wins() {
        poker = new Poker("2H 3D 5S 9C KD", "2C 3H 4S 8C AH");
        assertThat(poker.game()).contains("White");
    }

    @Test
    void tie() {
        poker = new Poker("2H 3D 5S 9C KD", "2C 3H 4S 8C KH");
        assertThat(poker.game()).contains("Tie");
    }


}