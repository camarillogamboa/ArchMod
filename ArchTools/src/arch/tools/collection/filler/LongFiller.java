package arch.tools.collection.filler;

@FunctionalInterface
public interface LongFiller {

    void put(long value);

    default void putAll(long... values) {
        for (var value : values) put(value);
    }

}
