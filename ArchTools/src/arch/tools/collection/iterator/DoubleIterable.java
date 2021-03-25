package arch.tools.collection.iterator;

import java.util.function.DoubleConsumer;

@FunctionalInterface
public interface DoubleIterable {

    DoubleIterator iterator();

    default void forEach(DoubleConsumer action) {
        Iterators.iterate(iterator(), action);
    }

}
