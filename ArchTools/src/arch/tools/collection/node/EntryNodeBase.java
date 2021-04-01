package arch.tools.collection.node;

import java.util.Objects;

public class EntryNodeBase<K, V> extends NodeBase<V> implements EntryNode<K, V> {

    private final K key;

    public EntryNodeBase(K key, V value) {
        super(value);
        this.key = Objects.requireNonNull(key);
    }

    @Override
    public final K getKey() {
        return key;
    }

}
