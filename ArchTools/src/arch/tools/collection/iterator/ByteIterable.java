package arch.tools.collection.iterator;

import arch.tools.function.ByteConsumer;

@FunctionalInterface
public interface ByteIterable {

    ByteIterator iterator();

    default void forEach(ByteConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
