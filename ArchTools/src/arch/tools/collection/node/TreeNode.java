package arch.tools.collection.node;

import arch.tools.property.ObservableReferenceProperty;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public abstract class TreeNode<V> extends Node<V> {

    private int level;

    private final ObservableReferenceProperty<TreeNode<V>> parentProperty;
    private final List<TreeNode<V>> children;

    public TreeNode(V value) {
        super(value);

        this.level = 0;

        this.parentProperty = new ObservableReferenceProperty<>();
        this.parentProperty.addObserver((preview, now) -> {
            if (preview != null) preview.children.remove(this);
            updateLevel();
        });

        this.children = new LinkedList<>() {
            @Override
            public boolean add(TreeNode<V> treeNode) {
                Objects.requireNonNull(treeNode);
                treeNode.setParent(TreeNode.this);
                return super.add(treeNode);
            }
        };

    }

    public TreeNode() {
        this(null);
    }

    public final void setParent(TreeNode<V> parent) {
        if (equals(parent))
            throw new RuntimeException("Operación inválida:\n" + "No se puede establecer como padre el nodo actual");
        parentProperty.set(parent);
    }

    public final TreeNode<V> getParent() {
        return parentProperty.get();
    }

    public final int getLevel() {
        return level;
    }

    public final int branchSize() {
        return 1 + children.stream().mapToInt(TreeNode::branchSize).sum();
    }

    public final boolean hasParent() {
        return parentProperty.get() != null;
    }

    public final boolean hasChildren() {
        return !children.isEmpty();
    }

    public final boolean isLeaf() {
        return children.isEmpty();
    }

    public abstract int leafIndex();

    public final List<TreeNode<V>> getChildren() {
        return children;
    }

    private void updateLevel() {
        level = parentProperty.get() != null ? parentProperty.get().level + 1 : 0;
        children.forEach(TreeNode::updateLevel);
    }

    public final void traverseBranchPreorder(Consumer<TreeNode<V>> consumer) {
        traverseBranchPreorder(this, consumer);
    }

    public final void traverseBranchPostorder(Consumer<TreeNode<V>> consumer) {
        traverseBranchPostorder(this, consumer);
    }

    public static <E> void traverseBranchPreorder(TreeNode<E> node, Consumer<TreeNode<E>> consumer) {
        consumer.accept(node);
        node.children.forEach(c -> traverseBranchPreorder(c, consumer));
    }

    public static <E> void traverseBranchPostorder(TreeNode<E> node, Consumer<TreeNode<E>> consumer) {
        node.children.forEach(c -> traverseBranchPostorder(c, consumer));
        consumer.accept(node);
    }

}
