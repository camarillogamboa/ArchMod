package arch.tools.function;

@FunctionalInterface
public interface DoubleToByteBiFunction {

    byte applyAsByte(double a, double b);

}
