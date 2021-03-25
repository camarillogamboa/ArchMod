package arch.tools.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface FloatBiFunction<R> {

    R apply(float a, float b);

    default <T> FloatBiFunction<T> andThen(Function<R, T> after) {
        Objects.requireNonNull(after);
        return (a, b) -> after.apply(apply(a, b));
    }

}
