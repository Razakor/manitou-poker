package razakor.poker.enums;

public enum Color {
    RED("R"),
    BLACK("B");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}