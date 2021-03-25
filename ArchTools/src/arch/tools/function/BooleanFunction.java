package arch.tools.function;

@FunctionalInterface
public interface BooleanFunction<R> {

    R apply(boolean b);

}
