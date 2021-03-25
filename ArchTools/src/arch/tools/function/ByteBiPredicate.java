package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ByteBiPredicate {

    boolean test(byte a, byte b);

    default ByteBiPredicate and(ByteBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) && other.test(a, b);
    }

    default ByteBiPredicate negate() {
        return (a, b) -> !test(a, b);
    }

    default ByteBiPredicate or(ByteBiPredicate other) {
        Objects.requireNonNull(other);
        return (a, b) -> test(a, b) || other.test(a, b);
    }

}
