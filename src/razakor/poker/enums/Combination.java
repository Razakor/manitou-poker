package razakor.poker.enums;

public enum Combination {
    ROYAL_FLUSH(1),
    STRAIGHT_FLUSH(2),
    FOUR_OF_A_KIND(3),
    FULL_HOUSE(4),
    FLUSH(5),
    STRAIGHT(6),
    THREE_OF_A_KIND(7),
    TWO_PAIR(8),
    HIGH_CARD(9),
    PAIR(10);

    private final int value;

    Combination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}