package arch.tools.collection.node;

public interface Node<V> {

    void setValue(V value);

    V getValue();

    default boolean hasValue() {
        return getValue() != null;
    }

    default boolean equalsTo(Object o) {
        return hasValue() && getValue().equals(o);
    }

}
