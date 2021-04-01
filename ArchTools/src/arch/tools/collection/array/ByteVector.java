package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface ByteVector extends ReadOnlyByteVector, Prototype<ByteVector> {

    void setValueOf(int index, byte value);

    default void setAll(byte... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
