package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ByteBiConsumer {

    void accept(byte a, byte b);

    default ByteBiConsumer andThen(ByteBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
