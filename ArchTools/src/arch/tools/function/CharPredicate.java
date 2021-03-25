package arch.tools.function;

import java.util.Objects;

public interface CharPredicate {

    boolean test(char c);

    default CharPredicate and(CharPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) && other.test(value);
    }

    default CharPredicate negate() {
        return value -> !test(value);
    }

    default CharPredicate or(CharPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) || other.test(value);
    }

}
