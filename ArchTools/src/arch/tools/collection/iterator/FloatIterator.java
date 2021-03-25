package arch.tools.collection.iterator;

import arch.tools.function.FloatConsumer;

public interface FloatIterator extends Sequential {

    float next();

    default void forEachRemaining(FloatConsumer action) {
        Iterators.iterate(this, action);
    }

}
