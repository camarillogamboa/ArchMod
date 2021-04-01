package arch.tools.collection.array;

import java.util.Objects;

public class LongArray extends ReadOnlyLongArray implements LongVector {

    public LongArray(long[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public LongArray(int length) {
        this(new long[length]);
    }

    @Override
    public final void setValueOf(int index, long value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public LongArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
