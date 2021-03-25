package arch.tools.function;

@FunctionalInterface
public interface ToShortBiFunction<A, B> {

    short applyAsShort(A a, B b);

}
