public class Card {
    private String value;
    private String suit;

    Card(String suit, String value) {
        this.value = value;
        this.suit = suit;
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
