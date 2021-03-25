package arch.tools.collection.iterator;

import arch.tools.function.BooleanConsumer;

@FunctionalInterface
public interface BooleanIterable {

    BooleanIterator iterator();

    default void forEach(BooleanConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
