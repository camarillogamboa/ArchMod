package arch.tools.collection.table;

import java.util.function.BiConsumer;

public interface TableIterable<K, V> {

    TableIterator<K, V> iterator();

    default void forEach(BiConsumer<K, V> consumer) {
        iterator().forEachRemaining(consumer);
    }

}
