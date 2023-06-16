package manitou.poker;

public class ANSI {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String RED_BACKGROUND = "\u001B[41m";

    public static String redText(String string) {
        return RED + string + RESET;
    }

    public static String blackText(String string) {
        return BLACK + string + RESET;
    }

    public static String redBackground(String string) {
        return RED_BACKGROUND + string + RESET;
    }
}