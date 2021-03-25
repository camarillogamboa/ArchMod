package arch.tools.function;

@FunctionalInterface
public interface ByteToDoubleFunction {

    ByteToDoubleFunction CAST = b -> b;

    double applyAsDouble(byte b);

}
