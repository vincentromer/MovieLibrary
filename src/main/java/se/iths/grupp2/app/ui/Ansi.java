package se.iths.grupp2.app.ui;


public final class Ansi {

    public static final String RESET = "\u001B[0m";
    public static final String GOLD = "\u001B[38;5;179m";
    public static final String RED = "\u001B[31m";
    public static final String GRAY = "\u001B[90m";
    public static final String BOLD = "\u001B[1m";
    public static final String BG_BLACK = "\u001B[40m";
    public static final String WHITE = "\u001B[97m";
    public static final String CLEAR_SCREEN = "\u001B[2J";
    public static final String CURSOR_HOME = "\u001B[H";

    private Ansi() {
    }
}