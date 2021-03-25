package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface DoubleBiPredicate {

    boolean test(double a, double b);

    default DoubleBiPredicate and(DoubleBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default DoubleBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default DoubleBiPredicate or(DoubleBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
