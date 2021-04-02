package arch.tools.collection.table;

import arch.tools.collection.iterator.Sequential;

import java.util.function.BiConsumer;

public interface TableIterator<K, V> extends Sequential {

    void consumeNext(BiConsumer<K, V> consumer);

    default void forEachRemaining(BiConsumer<K, V> consumer) {
        while (hasNext()) consumeNext(consumer);
    }

}
