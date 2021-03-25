package arch.tools.function;

@FunctionalInterface
public interface LongToDoubleBiFunction {

    double applyAsDouble(long a, long b);

}
