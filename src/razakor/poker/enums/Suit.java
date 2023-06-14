package razakor.poker.enums;

import java.util.NoSuchElementException;

public enum Suit {

    SPADES(1, "♠", Color.BLACK),
    HEARTS(2, "♥", Color.RED),
    DIAMONDS(3, "♦", Color.RED),
    CLUBS(4, "♣", Color.BLACK);

    private final int value;
    private final String name;
    private final Color color;

    Suit(int value, String name, Color color) {
        this.value = value;
        this.name = name;
        this.color = color;
    }

    public static Suit getSuit(int value) {
        for (Suit suit : Suit.values()) {
            if (suit.getValue() == value) return suit;
        }
        throw new NoSuchElementException("Suit " + value);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public static int getSize() {
        return Suit.values().length;
    }
}