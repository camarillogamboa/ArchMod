package arch.tools.collection.table;

import arch.tools.collection.array.ReferenceVector;
import arch.tools.desingpattern.prototype.Prototype;

public interface Table<K, V> extends ReadOnlyTable<K, V>, Prototype<Table<K, V>> {

    void put(K key, V value);

    default void putAll(TableIterable<K, V> tableIterable) {
        tableIterable.forEach(this::put);
    }

    @Override
    ReferenceVector<K> getKeys();

    @Override
    ReferenceVector<V> getValues();

}
