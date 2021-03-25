package arch.tools.io;

import java.io.PrintStream;

@FunctionalInterface
public interface Printable {

    default void print() {
        printIn(System.out);
    }

    void printIn(PrintStream out);

    default Printable before(Printable printable) {
        return out -> {
            printable.printIn(out);
            printIn(out);
        };
    }

    default Printable after(Printable printable) {
        return out -> {
            printIn(out);
            printable.printIn(out);
        };
    }
}
