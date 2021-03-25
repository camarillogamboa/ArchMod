package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface LongBiConsumer {

    void accept(long a, long b);

    default LongBiConsumer andThen(LongBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
