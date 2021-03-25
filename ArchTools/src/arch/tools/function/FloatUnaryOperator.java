package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface FloatUnaryOperator {

    float applyAsFloat(float operand);

    default FloatUnaryOperator compose(FloatUnaryOperator before) {
        Objects.requireNonNull(before);
        return t -> applyAsFloat(before.applyAsFloat(t));
    }

    default FloatUnaryOperator andThen(FloatUnaryOperator after) {
        Objects.requireNonNull(after);
        return t -> after.applyAsFloat(applyAsFloat(t));
    }

    default FloatUnaryOperator identity() {
        return t -> t;
    }

}
