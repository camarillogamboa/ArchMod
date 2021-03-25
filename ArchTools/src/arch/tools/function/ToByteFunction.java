package arch.tools.function;

@FunctionalInterface
public interface ToByteFunction<T> {

    byte applyAsByte(T t);

}
