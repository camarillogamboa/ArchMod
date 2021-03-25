package arch.tools.function;

@FunctionalInterface
public interface LongToByteBiFunction {

    byte applyAsByte(long a, long b);

}
