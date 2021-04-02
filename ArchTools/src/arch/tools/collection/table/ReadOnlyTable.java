package arch.tools.collection.table;

import arch.tools.collection.Sizable;
import arch.tools.collection.array.ReadOnlyReferenceVector;

public interface ReadOnlyTable<K, V> extends TableIterable<K, V>, Sizable {

    V get(K key);

    ReadOnlyReferenceVector<K> getKeys();

    ReadOnlyReferenceVector<V> getValues();

}
