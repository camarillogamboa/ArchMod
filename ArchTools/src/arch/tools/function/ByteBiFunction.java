package arch.tools.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface ByteBiFunction<R> {

    R apply(byte a, byte b);

    default <T> ByteBiFunction<T> andThen(Function<R, T> after) {
        Objects.requireNonNull(after);
        return (a, b) -> after.apply(apply(a, b));
    }

}
