package arch.tools.function;

@FunctionalInterface
public interface ByteFunction<R> {

    R apply(byte b);

}
