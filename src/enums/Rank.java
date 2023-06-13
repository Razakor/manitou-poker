package enums;

import java.util.NoSuchElementException;

public enum Rank {

    ACE(1, "A"),
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K");

    private final int value;
    private final String name;

    Rank(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static Rank getRank(int value) {
        for (Rank rank : Rank.values()) {
            if (rank.getValue() == value) return rank;
        }
        throw new NoSuchElementException("Rank " + value);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static int getSize() {
        return Rank.values().length;
    }
}