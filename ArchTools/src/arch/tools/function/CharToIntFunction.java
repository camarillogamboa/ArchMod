package arch.tools.function;

@FunctionalInterface
public interface CharToIntFunction {

    CharToIntFunction CODE_POINT = c -> c;

    int applyAsInt(char c);

}
