package arch.tools.collection.node;

public class NodeBase<V> implements Node<V> {

    private V value;

    public NodeBase(V value) {
        this.value = value;
    }

    public NodeBase() {
        this(null);
    }

    public final void setValue(V value) {
        this.value = value;
    }

    public final V getValue() {
        return value;
    }

}
