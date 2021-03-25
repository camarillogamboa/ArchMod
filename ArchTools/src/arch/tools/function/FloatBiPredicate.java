package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface FloatBiPredicate {

    boolean test(float a, float b);

    default FloatBiPredicate and(FloatBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default FloatBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default FloatBiPredicate or(FloatBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
