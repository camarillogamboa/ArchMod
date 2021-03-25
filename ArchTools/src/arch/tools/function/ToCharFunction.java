package arch.tools.function;

@FunctionalInterface
public interface ToCharFunction<T> {

    char applyAsChar(T t);

}
