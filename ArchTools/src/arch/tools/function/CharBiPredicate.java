package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface CharBiPredicate {

    boolean test(char a, char b);

    default CharBiPredicate and(CharBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default CharBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default CharBiPredicate or(CharBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
