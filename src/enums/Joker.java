package enums;

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
        return "J" + color.getName();
    }
}
