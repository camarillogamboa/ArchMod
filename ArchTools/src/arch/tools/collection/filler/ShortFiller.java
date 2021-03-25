package arch.tools.collection.filler;

@FunctionalInterface
public interface ShortFiller {

    void put(short value);

    default void putAll(short... values) {
        for (var value : values) put(value);
    }

}
