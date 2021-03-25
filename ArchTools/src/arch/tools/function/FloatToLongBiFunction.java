package arch.tools.function;

@FunctionalInterface
public interface FloatToLongBiFunction {

    long applyAsLong(float a, float b);

}
