package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ShortUnaryOperator {

    short applyAsShort(short s);

    default ShortUnaryOperator compose(ShortUnaryOperator before) {
        Objects.requireNonNull(before);
        return s -> applyAsShort(before.applyAsShort(s));
    }

    default ShortUnaryOperator andThen(ShortUnaryOperator after) {
        Objects.requireNonNull(after);
        return s -> after.applyAsShort(applyAsShort(s));
    }

    static ShortUnaryOperator identity() {
        return b -> b;
    }

}
