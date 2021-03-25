package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ShortConsumer {

    void accept(short s);

    default ShortConsumer andThen(ShortConsumer after) {
        Objects.requireNonNull(after);
        return s -> {
            accept(s);
            after.accept(s);
        };
    }

}
