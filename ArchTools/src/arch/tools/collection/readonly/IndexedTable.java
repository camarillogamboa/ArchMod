package arch.tools.collection.readonly;

import arch.tools.collection.array.ReadOnlyReferenceArray;
import arch.tools.collection.array.ReferenceArrayFiller;
import arch.tools.collection.node.BinaryTreeNode;
import arch.tools.collection.node.ComparableEntryNode;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;

public class IndexedTable<K extends Comparable<K>, V> extends ReadOnlyReferenceArray<ComparableEntryNode<K, V>> {

    private BinaryTreeNode<ComparableEntryNode<K, V>> root;

    @SafeVarargs
    private IndexedTable(ComparableEntryNode<K, V>... entries) {
        super(entries);
        for (var entry : entries)
            if (root == null) root = new BinaryTreeNode<>(entry);
            else placeNode(root, new BinaryTreeNode<>(entry));
    }

    private void placeNode(BinaryTreeNode<ComparableEntryNode<K, V>> parent, BinaryTreeNode<ComparableEntryNode<K, V>> currentNode) {
        int value = currentNode.getValue().compareTo(parent.getValue());

        if (value < 0) {
            if (!parent.hasLeft()) parent.setLeft(currentNode);
            else placeNode(parent.getLeft(), currentNode);
        } else if (value > 0) {
            if (!parent.hasRight()) parent.setRight(currentNode);
            else placeNode(parent.getRight(), currentNode);
        } else throw new RuntimeException("Entrada duplicada");
    }

    public final V get(K key) {
        Objects.requireNonNull(key);
        if (!isEmpty()) {
            {
                var entry = valueOf(0);

                if (entry.getKey().equals(key) || (entry = valueOf(size() - 1)).getKey().equals(key))
                    return entry.getValue();
            }
            return findInTree(root, key);
        }
        return null;
    }

    private V findInTree(BinaryTreeNode<ComparableEntryNode<K, V>> currentNode, K key) {
        if (currentNode != null) {
            int value = key.compareTo(currentNode.getValue().getKey());

            if (value < 0) return findInTree(currentNode.getLeft(), key);
            else if (value > 0) return findInTree(currentNode.getRight(), key);
            else return currentNode.getValue().getValue();
        }
        return null;
    }

    public K[] getKeys(IntFunction<K[]> factory) {
        var array = factory.apply(size());

        for (int i = 0; i < array.length; i++) array[i] = valueOf(i).getKey();

        return array;
    }

    public V[] getValues(IntFunction<V[]> factory) {
        var array = factory.apply(size());

        for (int i = 0; i < array.length; i++) array[i] = valueOf(i).getValue();

        return array;
    }

    @SafeVarargs
    public static <K extends Comparable<K>, V> IndexedTable<K, V> create(ComparableEntryNode<K, V>... entries) {
        return new IndexedTable<>(entries);
    }

    public static <K extends Comparable<K>, V> IndexedTable<K, V> create(Map<K, V> map) {
        Objects.requireNonNull(map);
        ComparableEntryNode<K, V>[] entries = new ComparableEntryNode[map.size()];

        var filler = new ReferenceArrayFiller<>(entries);

        for (var entry : map.entrySet()) filler.put(new ComparableEntryNode<>(entry.getKey(), entry.getValue()));

        return create(entries);
    }

    public static <K extends Comparable<K>, V> IndexedTable<K, V> create(K[] keys, V[] values) {
        Objects.requireNonNull(keys);
        Objects.requireNonNull(values);
        if (keys.length == values.length) {
            ComparableEntryNode<K, V>[] entries = new ComparableEntryNode[keys.length];

            for (int i = 0; i < entries.length; i++) entries[i] = new ComparableEntryNode<>(keys[i], values[i]);

            return create(entries);
        } else throw new IllegalArgumentException("llaves y valores deben de ser cantidades iguales");
    }

    private static <K extends Comparable<K>, V> IndexedTable<K, V> create(K[] keys, Function<K, V> function) {
        Objects.requireNonNull(keys);
        Objects.requireNonNull(function);

        ComparableEntryNode<K, V>[] entries = new ComparableEntryNode[keys.length];

        var filler = new ReferenceArrayFiller<>(entries);

        for (var key : keys) filler.put(new ComparableEntryNode<>(key, function.apply(key)));

        return create(entries);
    }

}
