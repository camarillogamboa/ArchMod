package arch.tools.function;

@FunctionalInterface
public interface LongToIntBiFunction {

    int applyAsInt(long a, long b);

}
