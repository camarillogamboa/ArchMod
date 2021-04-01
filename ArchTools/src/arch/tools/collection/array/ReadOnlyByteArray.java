package arch.tools.collection.array;

import arch.tools.collection.iterator.ByteIterator;
import arch.tools.collection.iterator.Iterators;

import java.util.Arrays;

public class ReadOnlyByteArray implements ReadOnlyByteVector {

    protected final byte[] elements;

    public ReadOnlyByteArray(byte... elements) {
        this.elements = elements;
    }

    @Override
    public final int size() {
        return elements.length;
    }

    @Override
    public final byte valueOf(int index) {
        return elements[index < 0 ? elements.length + index : index];
    }

    @Override
    public final ByteIterator iterator() {
        return Iterators.iteratorOf(elements);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyByteArray) o;
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }

}
