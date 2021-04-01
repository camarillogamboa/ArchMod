package arch.tools.collection.array;

import java.util.Objects;

public class ReferenceArray<E> extends ReadOnlyReferenceArray<E> implements ReferenceVector<E> {

    public ReferenceArray(E[] elements) {
        super(Objects.requireNonNull(elements));
    }

    @Override
    public void setValueOf(int index, E value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public ReferenceArray<E> cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
