package arch.tools.function;

import java.util.Objects;

public interface BytePredicate {

    boolean test(byte value);

    default BytePredicate and(BytePredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) && other.test(value);
    }

    default BytePredicate negate() {
        return value -> !test(value);
    }

    default BytePredicate or(BytePredicate other) {
        Objects.requireNonNull(other);
        return value -> test(value) || other.test(value);
    }

}
