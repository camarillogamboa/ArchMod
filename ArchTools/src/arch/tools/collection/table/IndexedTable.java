package arch.tools.collection.table;

import arch.tools.collection.array.Arrays;
import arch.tools.collection.array.ReadOnlyReferenceVector;
import arch.tools.collection.node.BinaryTreeNode;
import arch.tools.collection.node.ComparableEntryNode;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BiConsumer;

public class IndexedTable<K extends Comparable<K>, V> implements ReadOnlyTable<K, V> {

    private final ReadOnlyReferenceVector<ComparableEntryNode<K, V>> entryVector;

    private BinaryTreeNode<ComparableEntryNode<K, V>> root;

    private final ReadOnlyReferenceVector<K> keys;
    private final ReadOnlyReferenceVector<V> values;

    @SafeVarargs
    public IndexedTable(ComparableEntryNode<K, V>... entries) {
        this.entryVector = Arrays.readOnlyArrayOf(entries);

        for (var entry : entries)
            if (root == null) root = new BinaryTreeNode<>(entry);
            else placeNode(root, new BinaryTreeNode<>(entry));

        this.keys = new ReadOnlyReferenceVector<>() {

            @Override
            public int size() {
                return entryVector.size();
            }

            @Override
            public K valueOf(int index) {
                return entryVector.valueOf(index).getKey();
            }

            @Override
            public Iterator<K> iterator() {
                var iterator = entryVector.iterator();
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public K next() {
                        return iterator.next().getKey();
                    }
                };
            }
        };

        this.values = new ReadOnlyReferenceVector<>() {

            @Override
            public int size() {
                return entryVector.size();
            }

            @Override
            public V valueOf(int index) {
                return entryVector.valueOf(index).getValue();
            }

            @Override
            public Iterator<V> iterator() {
                var iterator = entryVector.iterator();
                return new Iterator<>() {
                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public V next() {
                        return iterator.next().getValue();
                    }
                };
            }
        };
    }

    @Override
    public int size() {
        return entryVector.size();
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

    @Override
    public final V get(K key) {
        Objects.requireNonNull(key);
        if (!entryVector.isEmpty()) {
            {
                var entry = entryVector.valueOf(0);

                if (entry.getKey().equals(key) || (entry = entryVector.valueOf(size() - 1)).getKey().equals(key))
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

    public ReadOnlyReferenceVector<K> getKeys() {
        return keys;
    }

    public ReadOnlyReferenceVector<V> getValues() {
        return values;
    }

    @Override
    public TableIterator<K, V> iterator() {
        var iterator = entryVector.iterator();
        return new TableIterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public void consumeNext(BiConsumer<K, V> consumer) {
                var entry = iterator.next();
                consumer.accept(entry.getKey(), entry.getValue());
            }

        };
    }

}
