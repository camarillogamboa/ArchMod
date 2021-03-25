package arch.tools.function;

@FunctionalInterface
public interface ToByteBiFunction<A, B> {

    byte applyAsByte(A a, B b);

}
