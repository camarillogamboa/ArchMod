package arch.tools.collection;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayStack<E> implements Stack<E> {

    private Object[] elements;

    public ArrayStack() {
        clear();
    }

    @Override
    public boolean add(E e) {
        var newArray = new Object[elements.length + 1];

        System.arraycopy(elements, 0, newArray, 0, elements.length);

        newArray[elements.length + 1] = e;

        elements = newArray;
        return false;
    }

    @Override
    public E peek() {
        if (!isEmpty()) return (E) elements[0];
        else throw new EmptyStackException();
    }

    @Override
    public E pop() {
        if (!isEmpty()) {
            var e = elements[0];

            var newArray = new Object[elements.length - 1];

            System.arraycopy(elements, 1, newArray, 0, newArray.length);

            elements = newArray;

            return (E) e;
        } else throw new EmptyStackException();
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public void clear() {
        this.elements = new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<>() {

            int index;

            {
                this.index = 0;
            }

            @Override
            public boolean hasNext() {
                return index < elements.length;
            }

            @Override
            public E next() {
                return (E) elements[index++];
            }

            @Override
            public void remove() {

            }
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ArrayStack<?>) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
