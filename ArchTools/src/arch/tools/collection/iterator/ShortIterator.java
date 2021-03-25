package arch.tools.collection.iterator;

import arch.tools.function.ShortConsumer;

public interface ShortIterator extends Sequential {

    short next();

    default void forEachRemaining(ShortConsumer action) {
        Iterators.iterate(this, action);
    }

}
