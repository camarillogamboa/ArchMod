package arch.tools.collection.iterator;

import arch.tools.function.FloatConsumer;

@FunctionalInterface
public interface FloatIterable {

    FloatIterator iterator();

    default void forEach(FloatConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
