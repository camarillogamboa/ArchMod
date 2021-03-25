package arch.tools.function;

import java.util.Objects;

public interface ShortBiConsumer {

    void accept(short a, short b);

    default ShortBiConsumer andThen(ShortBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
