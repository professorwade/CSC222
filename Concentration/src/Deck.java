import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private final String[] suits = {"Clubs", "Spades", "Hearts", "Diamonds"};
    private final String[] values = {"Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
        "Jack","Queen","King","Ace"};

    private final List<Card> cards = new ArrayList<>();
    private final List<Card> discards = new ArrayList<>();
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

    public Card getValueMatch(String value) {
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getValue().equals(value)) {
                Card c = cards.remove(i);
                discards.add(c);
                return c;
            }
        }
        throw new RuntimeException("Unable to find matching value");
    }

    /**
     *
     */
    Deck() {
        buildDeck();
    }

    /**
     *
     * @return Card Dealt
     */
    public Card dealCard() {
        Card c = cards.removeFirst();
        discards.add(c);
        return c;
    }
}
