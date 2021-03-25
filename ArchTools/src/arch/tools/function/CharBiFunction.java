package arch.tools.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface CharBiFunction<R> {

    CharBiFunction<String> CONCAT = (a, b) -> String.valueOf(a) + b;

    R apply(char a, char b);

    default <T> CharBiFunction<T> andThen(Function<R, T> after) {
        Objects.requireNonNull(after);
        return (a, b) -> after.apply(apply(a, b));
    }

}
