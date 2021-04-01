package arch.tools.collection.array;

import java.util.Objects;

public class FloatArray extends ReadOnlyFloatArray implements FloatVector {

    public FloatArray(float[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public FloatArray(int length) {
        this(new float[length]);
    }

    @Override
    public final void setValueOf(int index, float value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public FloatArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
