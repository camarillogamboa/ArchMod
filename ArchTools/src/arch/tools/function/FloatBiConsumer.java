package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface FloatBiConsumer {

    void accept(float a, float b);

    default FloatBiConsumer andThen(FloatBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
