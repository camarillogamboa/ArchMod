package arch.tools.function;

@FunctionalInterface
public interface ByteToShortFunction {

    ByteToShortFunction CAST = b -> (short) b;

    short applyAsShort(byte b);

}
