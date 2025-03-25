public class Card {
    private String value;
    private String suit;
    public boolean faceUp;
    public boolean matched;

    Card(String suit, String value) {
        this.value = value;
        this.suit = suit;
        this.faceUp = false; // face down by default
        this.matched = false;
    }

    @Override
    public String toString() {
        return value + " " + suit;
    }

    public String getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Card other = (Card) obj;
        return other.getValue().equals(value);
    }
}
