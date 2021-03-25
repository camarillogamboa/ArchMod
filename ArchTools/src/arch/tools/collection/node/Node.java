package arch.tools.collection.node;

public class Node<V> {

    private V value;

    public Node(V value) {
        this.value = value;
    }

    public Node() {
        this(null);
    }

    public final void setValue(V value) {
        this.value = value;
    }

    public final V getValue() {
        return value;
    }

    public final boolean hasValue() {
        return value != null;
    }

    public final boolean equalsTo(Object o) {
        return hasValue() && value.equals(o);
    }

}
