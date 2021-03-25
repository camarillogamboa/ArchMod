package arch.tools.collection.iterator;

import arch.tools.function.ByteConsumer;

public interface ByteIterator extends Sequential {

    byte next();

    default void forEachRemaining(ByteConsumer action) {
        Iterators.iterate(this, action);
    }

}
