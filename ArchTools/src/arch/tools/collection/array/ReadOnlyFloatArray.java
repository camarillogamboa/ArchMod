package arch.tools.collection.array;

import arch.tools.collection.iterator.FloatIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyFloatArray implements ReadOnlyFloatVector {

    private final float[] elements;

    public ReadOnlyFloatArray(float... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final float valueOf(int index) {
        return elements[index];
    }

    @Override
    public final FloatIterator iterator() {
        return Iterators.iterator(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyFloatArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
