package arch.tools.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface IntBiFunction<R> {

    R apply(int a, int b);

    default <T> IntBiFunction<T> andThen(Function<R, T> after) {
        Objects.requireNonNull(after);
        return (a, b) -> after.apply(apply(a, b));
    }

}
