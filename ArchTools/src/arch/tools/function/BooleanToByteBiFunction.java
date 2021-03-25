package arch.tools.function;

@FunctionalInterface
public interface BooleanToByteBiFunction {

    byte applyAsByte(boolean a, boolean b);

}
