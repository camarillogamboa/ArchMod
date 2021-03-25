package arch.tools.function;

@FunctionalInterface
public interface ToFloatFunction<T> {

    float applyAsFloat(T t);

}
