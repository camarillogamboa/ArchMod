package arch.tools.function;

@FunctionalInterface
public interface BooleanToLongFunction {

    long applyAsLong(boolean b);

}
