package arch.tools.collection;

import arch.tools.collection.node.DoubleLinkedNode;
import arch.tools.object.ObjectUtil;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedStack<E> implements Stack<E> {

    private int size;

    private DoubleLinkedNode<E> top;

    public LinkedStack() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    public boolean push(E e) {
        return add(e);
    }

    @Override
    public boolean add(E e) {
        var node = new DoubleLinkedNode<>(e);

        if (top != null) top.setPrevius(node);
        top = node;
        size++;
        return true;
    }

    public E peek() {
        if (top != null) return top.getValue();
        else throw new EmptyStackException();
    }

    public E pop() {
        if (!isEmpty()) {
            var back = top;
            top = top.getNext();
            back.setNext(null);
            size--;
            return back.getValue();
        }
        throw new EmptyStackException();
    }

    @Override
    public void clear() {
        top = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private DoubleLinkedNode<E> pointer;

            {
                pointer = top;
            }

            @Override
            public boolean hasNext() {
                return pointer != null;
            }

            @Override
            public E next() {
                if (hasNext()) {
                    var value = pointer.getValue();
                    pointer = pointer.getNext();
                    return value;
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                if (pointer != null) {
                    if (pointer == top) {
                        var back = top;
                        top = top.getNext();
                        back.setNext(null);
                    } else {
                        var previus = pointer.getPrevius();
                        var next = pointer.getNext();
                        previus.setNext(next);
                        pointer = next;
                    }
                    size--;
                } else throw new NoSuchElementException();
            }

        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (LinkedStack<?>) o;

        if (size == that.size) {
            var thisIterator = iterator();
            var theseIterator = that.iterator();

            while (thisIterator.hasNext() && theseIterator.hasNext())
                if (!Objects.equals(thisIterator.next(), theseIterator.next())) return false;
            return true;
        } else return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, ObjectUtil.hashCode(iterator()));
    }
}
