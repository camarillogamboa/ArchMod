package arch.tools.collection.iterator;

import java.util.function.IntConsumer;

public interface IntIterator extends Sequential {

    int next();

    default void forEachRemaining(IntConsumer action) {
        Iterators.iterate(this, action);
    }

}
