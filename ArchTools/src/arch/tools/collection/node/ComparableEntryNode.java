package arch.tools.collection.node;

public class ComparableEntryNode<K extends Comparable<K>, V> extends EntryNode<K, V> implements Comparable<ComparableEntryNode<K, V>> {

    public ComparableEntryNode(K key, V value) {
        super(key, value);
    }

    @Override
    public final int compareTo(ComparableEntryNode<K, V> o) {
        return getKey().compareTo(o.getKey());
    }
}
