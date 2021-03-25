package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface BooleanBiConsumer {

    void accept(boolean a, boolean b);

    default BooleanBiConsumer andThen(BooleanBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
