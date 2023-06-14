package razakor.poker.enums;

import razakor.poker.ANSI;

import java.util.NoSuchElementException;

public enum Joker {
    RED(Color.RED),
    BLACK(Color.BLACK);

    private final Color color;

    Joker (Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        switch (color) {
            case RED -> {
                return ANSI.redText("J");
            }
            case BLACK -> {
                return "J";
            }
        }
        throw new NoSuchElementException();
    }
}
