package arch.tools.collection.filler;

@FunctionalInterface
public interface ReferenceFiller<E> {

    void put(E value);

    default void putAll(E... values) {
        for (var value : values) put(value);
    }

}
