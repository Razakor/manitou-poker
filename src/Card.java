import enums.Rank;
import enums.Suit;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(int value) {
        int divider = Rank.getSize();
        value--;
        int rankNumber = (value % divider) + 1;
        int suitNumber = (value / divider) + 1;
        Rank rank = Rank.getRank(rankNumber);
        Suit suit = Suit.getSuit(suitNumber);
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return rank.getName() + suit.getName();
    }
}