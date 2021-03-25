package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface IntBiPredicate {

    boolean test(int a, int b);

    default IntBiPredicate and(IntBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default IntBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default IntBiPredicate or(IntBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
