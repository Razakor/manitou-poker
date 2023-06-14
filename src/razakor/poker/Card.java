package razakor.poker;

import razakor.poker.enums.Rank;
import razakor.poker.enums.Suit;

public class Card {

    private final Rank rank;
    private final Suit suit;
    private boolean used;

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

    public Suit getSuit() {
        return suit;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public boolean isUsed() {
        return used;
    }

    @Override
    public String toString() {
        String string = rank.getName() + suit.getName();
        if (used) {
            return ANSI.redText(string);
        } else {
            return string;
        }
    }
}