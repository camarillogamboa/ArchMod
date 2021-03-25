package arch.tools.collection.node;

import java.util.Objects;

public class EntryNode<K, V> extends Node<V> {

    private final K key;

    public EntryNode(K key, V value) {
        super(value);
        this.key = Objects.requireNonNull(key);
    }

    public final K getKey() {
        return key;
    }

}
