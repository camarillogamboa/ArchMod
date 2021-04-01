package arch.tools.collection.array;

import java.util.Objects;

public class BooleanArray extends ReadOnlyBooleanArray implements BooleanVector {

    public BooleanArray(boolean[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public BooleanArray(int length) {
        this(new boolean[length]);
    }

    @Override
    public final void setValueOf(int index, boolean value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public BooleanArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
