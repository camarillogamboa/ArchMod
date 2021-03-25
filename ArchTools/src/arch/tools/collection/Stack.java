package arch.tools.collection;

public interface Stack<E> extends AbstractCollection<E> {

    default boolean push(E e) {
        return add(e);
    }

    E peek();

    E pop();

}
