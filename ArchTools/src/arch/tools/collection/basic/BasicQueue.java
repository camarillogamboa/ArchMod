package arch.tools.collection.basic;

import arch.tools.collection.Sizable;
import arch.tools.collection.node.LinkedNode;
import arch.tools.object.ObjectUtil;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class BasicQueue<E> implements Iterable<E>, Sizable {

    private LinkedNode<E> firts;
    private LinkedNode<E> latest;

    private int size;

    public BasicQueue() {
        this.size = 0;
    }

    public boolean add(E e) {
        var node = new LinkedNode<>(e);

        if (firts == null) firts = node;
        else latest.setNext(node);

        latest = node;

        size++;

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            LinkedNode<E> current;

            {
                this.current = new LinkedNode<>();
                this.current.setNext(firts);
            }

            @Override
            public boolean hasNext() {
                return current.hasNext();
            }

            @Override
            public E next() {
                if (hasNext()) return (current = current.getNext()).getValue();
                else throw new NoSuchElementException();
            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (BasicQueue<?>) o;

        if (size == that.size) {
            var thisIterator = iterator();
            var thatIterator = that.iterator();

            while (thisIterator.hasNext() && thatIterator.hasNext())
                if (!thisIterator.next().equals(thatIterator.next())) return false;

            return !thisIterator.hasNext() && !thatIterator.hasNext();
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ObjectUtil.hashCode(iterator()), latest, size);
    }
}
