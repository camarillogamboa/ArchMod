package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ShortPredicate {

    boolean test(short s);

    default ShortPredicate and(ShortPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) && other.test(value);
    }

    default ShortPredicate negate() {
        return value -> !test(value);
    }

    default ShortPredicate or(ShortPredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) || other.test(value);
    }

}
