package arch.tools.collection.iterator;

import java.util.function.LongConsumer;

@FunctionalInterface
public interface LongIterable {

    LongIterator iterator();

    default void forEach(LongConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
