package manitou.poker.enums;

public enum Combination {
    ROYAL_FLUSH(1),
    STRAIGHT_FLUSH(2),
    POKER(3),
    FOUR_OF_A_KIND(4),
    FULL_HOUSE(5),
    FLUSH(6),
    STRAIGHT(7),
    THREE_OF_A_KIND(8),
    TWO_PAIR(9),
    HIGH_PAIR(10),
    PAIR(11),
    ACE(12),
    HIGH_CARD(13);

    private final int value;

    Combination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}