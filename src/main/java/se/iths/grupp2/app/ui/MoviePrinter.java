
package se.iths.grupp2.app.ui;

import se.iths.grupp2.app.model.Movie;

public class MoviePrinter {

    public void print(String message) {
        IO.println(message);
    }

    public void printMenu(String... menuItems) {
        String divider = "━".repeat(52);

        IO.println();
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println(Ansi.GOLD + Ansi.BOLD +
                "                  MOVIE LIBRARY" + Ansi.RESET);
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println();

        for (String menuItem : menuItems) {
            IO.println("    " + menuItem);
        }

        IO.println();
        IO.println(Ansi.GOLD + "─".repeat(52) + Ansi.RESET);
    }

    public void printMovieInfo(Movie movie) {
        IO.println(String.format(
                "  %-4d %s",
                movie.getId(),
                movie.getTitle()
        ));
    }

    public void printMovieColumns() {
        IO.println(Ansi.GOLD +
                "  ID   TITLE" +
                Ansi.RESET);

        IO.println(Ansi.GOLD + "  " + "─".repeat(48) + Ansi.RESET);
    }

    public void printCategories() {
        String divider = "━".repeat(52);

        IO.println();
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println(Ansi.GOLD + Ansi.BOLD +
                "                    CATEGORIES" + Ansi.RESET);
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println();

        IO.println("    DRAMA             ACTION");
        IO.println("    COMEDY            HORROR");

        IO.println();
        IO.println(Ansi.GOLD + "─".repeat(52) + Ansi.RESET);
    }

    public void printMovieHeader(String category) {
        String divider = "━".repeat(52);
        String heading = category.trim().toUpperCase() + " MOVIES";
        String padding = " ".repeat(Math.max(0, (52 - heading.length()) / 2));

        IO.println();
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println(Ansi.GOLD + Ansi.BOLD + padding + heading + Ansi.RESET);
        IO.println(Ansi.GOLD + divider + Ansi.RESET);
        IO.println();
    }

    public void printCategorySection(String category) {
        IO.println();
        IO.println(Ansi.GOLD + Ansi.BOLD
                + "  " + category.toUpperCase()
                + Ansi.RESET);

        IO.println(Ansi.GOLD
                + "  " + "─".repeat(48)
                + Ansi.RESET);
    }

    public void printMovieTotal(int count) {
        IO.println();
        IO.println(Ansi.GOLD + "  " + "─".repeat(48) + Ansi.RESET);
        IO.println(Ansi.GRAY + "  Total: " + count + " movies" + Ansi.RESET);
    }

    public void printGoodbye() {
        IO.println();
        IO.println(Ansi.GOLD + "  " + "─".repeat(48) + Ansi.RESET);
        IO.println("             Thank you for visiting!");
        IO.println(Ansi.GRAY + "             See you at the movies." + Ansi.RESET);
    }

    public void printError(String message) {
        IO.println();
        IO.println(Ansi.RED + "  ! " + message + Ansi.RESET);
    }
}
