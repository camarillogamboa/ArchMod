package arch.tools.collection.array;

import arch.tools.collection.iterator.DoubleIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyDoubleArray implements ReadOnlyDoubleVector {

    protected final double[] elements;

    public ReadOnlyDoubleArray(double... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final double valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final DoubleIterator iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyDoubleArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
