package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface CharUnaryOperator {

    char applyAsChar(char c);

    default CharUnaryOperator compose(CharUnaryOperator before) {
        Objects.requireNonNull(before);
        return c -> applyAsChar(before.applyAsChar(c));
    }

    default CharUnaryOperator andThen(CharUnaryOperator after) {
        Objects.requireNonNull(after);
        return c -> after.applyAsChar(applyAsChar(c));
    }

    static BooleanUnaryOperator identity() {
        return c -> c;
    }

}
