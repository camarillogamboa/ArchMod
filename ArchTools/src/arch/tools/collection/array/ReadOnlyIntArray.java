package arch.tools.collection.array;

import arch.tools.collection.iterator.IntIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyIntArray implements ReadOnlyIntVector {

    protected final int[] elements;

    public ReadOnlyIntArray(int... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final int valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final IntIterator iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyIntArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
