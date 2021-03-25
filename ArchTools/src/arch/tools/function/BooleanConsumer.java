package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface BooleanConsumer {

    void accept(boolean b);

    default BooleanConsumer andThen(BooleanConsumer after) {
        Objects.requireNonNull(after);
        return b -> {
            accept(b);
            after.accept(b);
        };
    }

}