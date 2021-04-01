package arch.tools.collection.readonly;

import arch.tools.collection.array.ReadOnlyReferenceArray;
import arch.tools.collection.array.ReadOnlyReferenceVector;
import arch.tools.collection.node.BinaryTreeNode;
import arch.tools.collection.node.ComparableEntryNode;
import arch.tools.collection.node.ComparableEntryNodeBase;

import java.util.Iterator;
import java.util.Objects;

public class IndexedTable<K extends Comparable<K>, V> extends ReadOnlyReferenceArray<ComparableEntryNode<K, V>> {

    private BinaryTreeNode<ComparableEntryNodeBase<K, V>> root;

    private final ReadOnlyReferenceVector<K> keys;
    private final ReadOnlyReferenceVector<V> values;

    @SafeVarargs
    public IndexedTable(ComparableEntryNodeBase<K, V>... entries) {
        super(entries);
        for (var entry : entries)
            if (root == null) root = new BinaryTreeNode<>(entry);
            else placeNode(root, new BinaryTreeNode<>(entry));

        this.keys = new ReadOnlyReferenceVector<>() {

            @Override
            public int size() {
                return IndexedTable.this.size();
            }

            @Override
            public K valueOf(int index) {
                return IndexedTable.this.valueOf(index).getKey();
            }

            @Override
            public Iterator<K> iterator() {
                var iterator = IndexedTable.this.iterator();
                return new Iterator<K>() {
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
                return IndexedTable.this.size();
            }

            @Override
            public V valueOf(int index) {
                return IndexedTable.this.valueOf(index).getValue();
            }

            @Override
            public Iterator<V> iterator() {
                var iterator = IndexedTable.this.iterator();
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

    private void placeNode(BinaryTreeNode<ComparableEntryNodeBase<K, V>> parent, BinaryTreeNode<ComparableEntryNodeBase<K, V>> currentNode) {
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

    private V findInTree(BinaryTreeNode<ComparableEntryNodeBase<K, V>> currentNode, K key) {
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

}
