package arch.tools.collection.iterator;

import arch.tools.function.BooleanConsumer;

public interface BooleanIterator extends Sequential {

    boolean next();

    default void forEachRemaining(BooleanConsumer action) {
        Iterators.iterate(this, action);
    }

}
