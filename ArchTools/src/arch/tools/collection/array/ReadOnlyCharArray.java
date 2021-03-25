package arch.tools.collection.array;

import arch.tools.collection.iterator.CharIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyCharArray implements ReadOnlyCharVector {

    private final char[] elements;

    public ReadOnlyCharArray(char... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final char valueOf(int index) {
        return elements[index];
    }

    @Override
    public final CharIterator iterator() {
        return Iterators.iterator(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyCharArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
