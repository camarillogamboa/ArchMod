package arch.tools.collection.array;

import java.util.Objects;

public class IntArray extends ReadOnlyIntArray implements IntVector {

    public IntArray(int[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public IntArray(int length) {
        this(new int[length]);
    }

    @Override
    public final void setValueOf(int index, int value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public IntArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}