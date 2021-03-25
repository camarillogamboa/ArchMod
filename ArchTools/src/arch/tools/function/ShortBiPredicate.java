package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ShortBiPredicate {

    boolean test(short a, short b);

    default ShortBiPredicate and(ShortBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default ShortBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default ShortBiPredicate or(ShortBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
