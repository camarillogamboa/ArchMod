package arch.tools.collection.iterator;

import arch.tools.collection.node.DoubleLinkedNode;

import java.io.Flushable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public final class Pointer<E> implements Iterator<E>, Flushable {

    private final Iterator<E> iterator;

    private DoubleLinkedNode<E> first;
    private DoubleLinkedNode<E> last;

    private DoubleLinkedNode<E> pointer;

    public Pointer(Iterator<E> iterator) {
        this.iterator = Objects.requireNonNull(iterator);
    }

    public E getCurrentValue() {
        return pointer != null ? pointer.getValue() : null;
    }

    private E add(E e) {
        var node = new DoubleLinkedNode<>(e);

        if (first == null) last = first = node;
        else {
            last.setNext(node);
            last = node;
        }

        pointer = node;

        return e;
    }

    @Override
    public boolean hasNext() {
        return (pointer != null && pointer.hasNext()) || iterator.hasNext();
    }

    @Override
    public E next() {
        if (pointer != null && pointer.hasNext()) return (pointer = pointer.getNext()).getValue();

        if (iterator.hasNext()) return add(iterator.next());
        else throw new NoSuchElementException();
    }

    public boolean hasPrevius() {
        return (pointer != null && pointer.hasPrevius());
    }

    public E previus() {
        if (hasPrevius()) return (pointer = pointer.getPrevius()).getValue();
        else throw new NoSuchElementException();
    }

    public void moveToFirst() {
        pointer = first;
    }

    public void moveToLast() {
        pointer = last;
    }

    public void trim() {
        first = pointer;
        first.setPrevius(null);
    }

    @Override
    public void flush() {
        moveToLast();
        trim();
    }

}
