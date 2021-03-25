package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface BooleanUnaryOperator {

    BooleanUnaryOperator NOT = a -> !a;

    boolean applyAsBoolean(boolean b);

    default BooleanUnaryOperator compose(BooleanUnaryOperator before) {
        Objects.requireNonNull(before);
        return b -> applyAsBoolean(before.applyAsBoolean(b));
    }

    default BooleanUnaryOperator andThen(BooleanUnaryOperator after) {
        Objects.requireNonNull(after);
        return b -> after.applyAsBoolean(applyAsBoolean(b));
    }

    static BooleanUnaryOperator identity() {
        return b -> b;
    }

}
