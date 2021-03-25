package arch.tools.collection.array;

import arch.tools.collection.iterator.Iterators;
import arch.tools.collection.iterator.ShortIterator;

import java.util.Arrays;

public class ReadOnlyShortArray implements ReadOnlyShortVector {

    private final short[] elements;

    public ReadOnlyShortArray(short... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final short valueOf(int index) {
        return elements[index];
    }

    @Override
    public final ShortIterator iterator() {
        return Iterators.iterator(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyShortArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
