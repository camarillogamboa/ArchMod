package arch.tools.collection.iterator;

public final class DoubleRangeIterator implements DoubleIterator {

    private final double end;
    private final double advance;

    private double pointer;

    public DoubleRangeIterator(double start, double end, double advance) {
        this.end = end;
        this.advance = advance;

        this.pointer = start - advance;
    }

    public DoubleRangeIterator(double start, double end) {
        this(start, end, 1);
    }

    public DoubleRangeIterator(double end) {
        this(0, end);
    }

    @Override
    public boolean hasNext() {
        return pointer < end;
    }

    @Override
    public double next() {
        return pointer += advance;
    }

}
