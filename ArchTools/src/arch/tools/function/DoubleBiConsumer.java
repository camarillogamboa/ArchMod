package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface DoubleBiConsumer {

    void accept(double a, double b);

    default DoubleBiConsumer andThen(DoubleBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
