package arch.tools.collection.iterator;

import java.util.function.DoubleConsumer;

public interface DoubleIterator extends Sequential {

    double next();

    default void forEachRemaining(DoubleConsumer action) {
        Iterators.iterate(this, action);
    }

}
