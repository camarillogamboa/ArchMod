package arch.tools.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface ShortBiFunction<R> {

    R apply(short a, short b);

    default <T> ShortBiFunction<T> andThen(Function<R, T> after) {
        Objects.requireNonNull(after);
        return (a, b) -> after.apply(apply(a, b));
    }

}
