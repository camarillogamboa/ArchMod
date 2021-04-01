package arch.tools.collection.array;

public class ShortArray extends ReadOnlyShortArray implements ShortVector {

    public ShortArray(short... elements) {
        super(elements);
    }

    public ShortArray(int lenght) {
        this(new short[lenght]);
    }

    @Override
    public final void setValueOf(int index, short value) {
        elements[index < 0 ? elements.length + index : index] = value;
    }

    @Override
    public ShortArray cloneThis() {
        return Arrays.newArrayOf(elements);
    }

}
