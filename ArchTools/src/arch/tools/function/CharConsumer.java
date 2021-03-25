package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface CharConsumer {

    void accept(char c);

    default CharConsumer andThen(CharConsumer after) {
        Objects.requireNonNull(after);
        return b -> {
            accept(b);
            after.accept(b);
        };
    }

}
