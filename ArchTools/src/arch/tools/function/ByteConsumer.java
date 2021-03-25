package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface ByteConsumer {

    void accept(byte b);

    default ByteConsumer andThen(ByteConsumer after) {
        Objects.requireNonNull(after);
        return b -> {
            accept(b);
            after.accept(b);
        };
    }

}
