package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface LongBiPredicate {

    boolean test(long a, long b);

    default LongBiPredicate and(LongBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default LongBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default LongBiPredicate or(LongBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
