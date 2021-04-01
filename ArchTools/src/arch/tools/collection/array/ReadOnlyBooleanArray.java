package arch.tools.collection.array;

import arch.tools.collection.iterator.BooleanIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyBooleanArray implements ReadOnlyBooleanVector {

    protected final boolean[] elements;

    public ReadOnlyBooleanArray(boolean... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    public final boolean valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final BooleanIterator iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyBooleanArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
