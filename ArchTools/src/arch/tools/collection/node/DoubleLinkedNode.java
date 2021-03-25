package arch.tools.collection.node;

public final class DoubleLinkedNode<V> extends Node<V> {

    private DoubleLinkedNode<V> next;
    private DoubleLinkedNode<V> previus;

    public DoubleLinkedNode(V value) {
        super(value);
    }

    public DoubleLinkedNode() {
        super();
    }

    public void setNext(DoubleLinkedNode<V> next) {
        if (this.next != null) this.next.previus = null;
        if (next != null) next.previus = this;
        this.next = next;
    }

    public void setPrevius(DoubleLinkedNode<V> previus) {
        if (this.previus != null) this.previus.next = null;
        if (previus != null) previus.next = this;
        this.previus = previus;
    }

    public DoubleLinkedNode<V> getNext() {
        return next;
    }

    public DoubleLinkedNode<V> getPrevius() {
        return previus;
    }

    public boolean hasNext() {
        return next != null;
    }

    public boolean hasPrevius() {
        return previus != null;
    }

}
