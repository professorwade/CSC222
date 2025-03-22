import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
    private String[] values = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Jack","Queen","King","Ace"};

    private List<Card> cards = new ArrayList<>();
    private List<Card> discards = new ArrayList<>();
    public final int SIZE = 52;

    /**
     *
     */
    private void buildDeck() {
        discards.clear();
        cards.clear();
        for (String suit : suits) {
            for (String value : values) {
                Card c = new Card(suit, value);
                cards.add(c);
            }
        }
        Collections.shuffle(cards); // shuffle deck
    }

    /**
     *
     */
    Deck() {
        buildDeck();
    }

    /**
     *
     */
    public void shuffle() {
        buildDeck();
    }

    /**
     *
     * @return
     */
    public Card dealCard() {
        Card c = cards.removeFirst();
        discards.add(c);
        return c;
    }
}
