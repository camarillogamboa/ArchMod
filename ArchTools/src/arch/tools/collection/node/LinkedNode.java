package arch.tools.collection.node;

public final class LinkedNode<V> extends Node<V> {

    private LinkedNode<V> next;

    public LinkedNode(V value) {
        super(value);
    }

    public LinkedNode() {
        super();
    }

    public void setNext(LinkedNode<V> next) {
        this.next = next;
    }

    public LinkedNode<V> getNext() {
        return next;
    }

    public boolean hasNext() {
        return next != null;
    }
}
