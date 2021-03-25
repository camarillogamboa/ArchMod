package arch.tools.collection.iterator;

import arch.tools.function.CharConsumer;

public interface CharIterable {

    CharIterator iterator();

    default void forEach(CharConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
