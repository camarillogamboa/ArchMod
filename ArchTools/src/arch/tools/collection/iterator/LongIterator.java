package arch.tools.collection.iterator;

import java.util.function.LongConsumer;

public interface LongIterator extends Sequential {

    long next();

    default void forEachRemaining(LongConsumer action) {
        Iterators.iterate(this, action);
    }

}
