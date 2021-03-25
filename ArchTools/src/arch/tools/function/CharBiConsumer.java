package arch.tools.function;

import java.util.Objects;

@FunctionalInterface
public interface CharBiConsumer {

    void accept(char a, char b);

    default CharBiConsumer andThen(CharBiConsumer after) {
        Objects.requireNonNull(after);

        return (a, b) -> {
            accept(a, b);
            after.accept(a, b);
        };
    }

}
