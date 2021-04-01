package arch.tools.collection.array;

import arch.tools.collection.iterator.Iterators;
import arch.tools.collection.iterator.LongIterator;

import java.util.Arrays;

public class ReadOnlyLongArray implements ReadOnlyLongVector {

    protected final long[] elements;

    public ReadOnlyLongArray(long... elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.length;
    }

    public final long valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final LongIterator iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyLongArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
