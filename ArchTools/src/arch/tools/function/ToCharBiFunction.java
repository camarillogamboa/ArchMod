package arch.tools.function;

@FunctionalInterface
public interface ToCharBiFunction<A, B> {

    char applyAsChar(A a, B b);

}
