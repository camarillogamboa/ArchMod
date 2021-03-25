package arch.tools.collection.iterator;

import arch.tools.function.ShortConsumer;

@FunctionalInterface
public interface ShortIterable {

    ShortIterator iterator();

    default void forEach(ShortConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
