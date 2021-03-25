package arch.tools.collection;

import arch.tools.collection.node.TreeNode;

public class StackTree<E> implements Tree<E> {

    private MoveCursor<E> cursor;

    private int size;
    private int levels;

    private TreeNode<E> root;

    public StackTree() {

    }

    @Override
    public final MoveCursor<E> getCursor() {
        return cursor;
    }

    @Override
    public final SequentialCursor<E> preorderCursor() {
        return null;
    }

    @Override
    public final SequentialCursor<E> postorderCursor() {
        return null;
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    public final boolean add(E e) {
        cursor.put(e);
        return false;
    }

    @Override
    public final void clear() {

    }

    public final int levels() {
        return levels;
    }

    public final StackTree<E> put(E e) {
        add(e);
        return this;
    }

    public final StackTree<E> push(E e) {
        cursor.putAndMove(e);
        return this;
    }

    public final StackTree<E> pop() {
        cursor.moveToParent();
        return this;
    }

    public final StackTree<E> pushAll(E... nonTerminalValues) {
        for (E e : nonTerminalValues) push(e);
        return this;
    }

    public final StackTree<E> putAll(E... terminalValues) {
        for (E e : terminalValues) put(e);
        return this;
    }

    public final StackTree<E> putBranch(E nonTerminalValue, E... terminalValues) {
        push(nonTerminalValue);
        putAll(terminalValues);
        pop();
        return this;
    }

    public final StackTree<E> popAll() {
        try {
            while (true) pop();
        } finally {
            return this;
        }
    }

    private final class StackTreeNode<E> extends TreeNode<E> {

        @Override
        public int leafIndex() {
            return 0;
        }
    }


    private class CursorBase<E> implements Cursor<E> {

        protected TreeNode<E> parent;
        protected TreeNode<E> current;

        @Override
        public E value() {
            return current != null ? current.getValue() : null;
        }

        @Override
        public int level() {
            return current != null ? current.getLevel() : -1;
        }

        @Override
        public boolean hasParent() {
            return parent != null;
        }

        @Override
        public boolean hasChildren() {
            return current != null && current.hasChildren();
        }

        @Override
        public boolean isVoid() {
            return current == null;
        }

        @Override
        public void remove() {

        }
    }

}
