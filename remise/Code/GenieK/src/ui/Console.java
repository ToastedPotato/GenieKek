package ui;

public class Console {

    /*
    Toutes les codes couleurs trouvés sur :
    https://stackoverflow.com/a/45444716/9390440
     */

    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static final String BLACK_UNDERLINED = "\033[4;30m";
    public static final String RED_UNDERLINED = "\033[4;31m";
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    public static final String YELLOW_UNDERLINED = "\033[4;33m";
    public static final String BLUE_UNDERLINED = "\033[4;34m";
    public static final String PURPLE_UNDERLINED = "\033[4;35m";
    public static final String CYAN_UNDERLINED = "\033[4;36m";
    public static final String WHITE_UNDERLINED = "\033[4;37m";

    public static String colorize(String code, String text) {
        return code + text + RESET;
    }

    public static String bar(int nb) {
        String string = "";
        for (int i = 0; i < nb; i++) {
            string += "\u2015";
        }
        return string;
    }

    public static String section() {
        String string = "";
        for (int i = 0; i < 76; i++) {
            if (i%2 == 0) string += "\u2015";
            else string += " ";
        }
        return colorize(CYAN, string);
    }

    public static String menu(String title) {
        int b = 75 - (title.length() + 5);
        return colorize(CYAN, bar(3)) + " " + colorize(YELLOW_BOLD, title) + " " + colorize(CYAN, bar(b));
    }

}
