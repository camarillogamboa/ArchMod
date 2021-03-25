package arch.tools.collection.iterator;

import java.util.function.IntConsumer;

@FunctionalInterface
public interface IntIterable {

    IntIterator iterator();

    default void forEach(IntConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
