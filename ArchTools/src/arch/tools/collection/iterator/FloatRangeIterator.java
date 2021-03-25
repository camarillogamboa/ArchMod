package arch.tools.collection.iterator;

public final class FloatRangeIterator implements FloatIterator {

    private final float end;
    private final float advance;

    private float pointer;

    public FloatRangeIterator(float start, float end, float advance) {
        this.end = end;
        this.advance = advance;

        this.pointer = start - advance;
    }

    public FloatRangeIterator(float start, float end) {
        this(start, end, 1);
    }

    public FloatRangeIterator(float end) {
        this(0, end);
    }

    @Override
    public boolean hasNext() {
        return pointer < end;
    }

    @Override
    public float next() {
        return pointer += advance;
    }

}
