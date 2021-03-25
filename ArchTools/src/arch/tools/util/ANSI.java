package arch.tools.util;

public interface ANSI {

    String BLACK = "\u001B[30m";
    String RED = "\u001B[31m";
    String GREEN = "\u001B[32m";
    String YELLOW = "\u001B[33m";
    String BLUE = "\u001B[34m";
    String PURPLE = "\u001B[35m";
    String CYAN = "\u001B[36m";
    String WHITE = "\u001B[37m";
    String RESET = "\u001B[0m";

    static String black(String string) {
        return BLACK + string + RESET;
    }

    static String red(String string) {
        return RED + string + RESET;
    }

    static String green(String string) {
        return GREEN + string + RESET;
    }

    static String yellow(String string) {
        return YELLOW + string + RESET;
    }

    static String blue(String string) {
        return BLUE + string + RESET;
    }

    static String purple(String string) {
        return PURPLE + string + RESET;
    }

    static String cyan(String string) {
        return CYAN + string + RESET;
    }

}
