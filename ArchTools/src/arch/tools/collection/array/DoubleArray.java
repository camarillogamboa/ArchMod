package arch.tools.collection.array;

import java.util.Objects;

public class DoubleArray extends ReadOnlyDoubleArray implements DoubleVector {

    public DoubleArray(double[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public DoubleArray(int length) {
        this(new double[length]);
    }

    @Override
    public final void setValueOf(int index, double value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public DoubleArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
