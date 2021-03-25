package arch.tools.function;

@FunctionalInterface
public interface ToFloatBiFunction<A, B> {

    float applyAsFloat(A a, B b);

}
