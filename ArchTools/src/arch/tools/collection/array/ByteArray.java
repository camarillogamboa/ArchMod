package arch.tools.collection.array;

import java.util.Objects;

public class ByteArray extends ReadOnlyByteArray implements ByteVector {

    public ByteArray(byte[] array) {
        super(Objects.requireNonNull(array));
    }

    public ByteArray(int length) {
        this(new byte[length]);
    }

    @Override
    public final void setValueOf(int index, byte value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public ByteArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
