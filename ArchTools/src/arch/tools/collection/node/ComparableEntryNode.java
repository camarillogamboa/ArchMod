package arch.tools.collection.node;

public interface ComparableEntryNode<K extends Comparable<K>, V> extends EntryNode<K, V>, Comparable<ComparableEntryNode<K, V>> {

    @Override
    default int compareTo(ComparableEntryNode<K, V> o) {
        return getKey().compareTo(o.getKey());
    }

}
