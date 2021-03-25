package arch.tools.function;

@FunctionalInterface
public interface BooleanToLongBiFunction {

    long applyAsLong(boolean a, boolean b);

}
