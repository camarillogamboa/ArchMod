package arch.tools.function;

@FunctionalInterface
public interface DoubleToLongBiFunction {

    long applyAsLong(double a, double b);

}
