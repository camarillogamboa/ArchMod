package arch.tools.function;

@FunctionalInterface
public interface ByteToLongBiFunction {

    long applyAsLong(byte a, byte b);

}
