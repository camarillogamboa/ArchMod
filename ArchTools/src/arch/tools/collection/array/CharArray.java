package arch.tools.collection.array;

import java.util.Objects;

public class CharArray extends ReadOnlyCharArray implements CharVector {

    public CharArray(char[] elements) {
        super(Objects.requireNonNull(elements));
    }

    public CharArray(int length) {
        this(new char[length]);
    }

    @Override
    public final void setValueOf(int index, char value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public CharVector cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
