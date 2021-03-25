package arch.tools.function;

@FunctionalInterface
public interface ToShortFunction<T> {

    short applyAsShort(T t);
}
