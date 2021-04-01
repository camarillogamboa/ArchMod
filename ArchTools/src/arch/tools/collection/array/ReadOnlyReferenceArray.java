package arch.tools.collection.array;

import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;
import java.util.Iterator;

public class ReadOnlyReferenceArray<E> implements ReadOnlyReferenceVector<E> {

    protected final E[] elements;

    @SafeVarargs
    public ReadOnlyReferenceArray(E... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final E valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final Iterator<E> iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyReferenceArray<?>) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
