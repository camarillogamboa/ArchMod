package arch.tools.collection.iterator;

import arch.tools.function.CharConsumer;

public interface CharIterator extends Sequential {

    char next();

    default void forEachRemaining(CharConsumer action) {
        Iterators.iterate(this, action);
    }

}
