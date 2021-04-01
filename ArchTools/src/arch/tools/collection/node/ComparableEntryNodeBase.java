package arch.tools.collection.node;

public class ComparableEntryNodeBase<K extends Comparable<K>, V> extends EntryNodeBase<K, V> implements ComparableEntryNode<K, V> {

    public ComparableEntryNodeBase(K key, V value) {
        super(key, value);
    }

}
