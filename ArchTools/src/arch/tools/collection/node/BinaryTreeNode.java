package arch.tools.collection.node;

public final class BinaryTreeNode<V> extends NodeBase<V> {

    private BinaryTreeNode<V> parent;

    private BinaryTreeNode<V> left;
    private BinaryTreeNode<V> right;

    public BinaryTreeNode(V value) {
        super(value);
    }

    public BinaryTreeNode() {
        super();
    }

    public void setLeft(BinaryTreeNode<V> left) {
        if (this.left != null) this.left.parent = null;
        if (left != null) {
            if (left.parent != null) {
                if (left.equals(left.parent.left)) left.parent.left = null;
                else left.parent.right = null;
            }
            left.parent = this;
        }
        this.left = left;
    }

    public void setRight(BinaryTreeNode<V> right) {
        if (this.right != null) this.right.parent = null;
        if (right != null) {
            if (right.parent != null) {
                if (right.equals(right.parent.right)) right.parent.right = null;
                else right.parent.left = null;
            }
            right.parent = this;
        }
        this.right = right;
    }

    public BinaryTreeNode<V> getParent() {
        return parent;
    }

    public BinaryTreeNode<V> getLeft() {
        return left;
    }

    public BinaryTreeNode<V> getRight() {
        return right;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

}
