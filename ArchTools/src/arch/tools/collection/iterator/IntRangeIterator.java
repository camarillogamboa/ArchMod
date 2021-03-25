package arch.tools.collection.iterator;

public final class IntRangeIterator implements IntIterator {

    private final int end;
    private final int advance;

    private int pointer;

    public IntRangeIterator(int start, int end, int advance) {
        this.end = end;
        this.advance = advance;

        this.pointer = start - advance;
    }

    public IntRangeIterator(int start, int end) {
        this(start, end, 1);
    }

    public IntRangeIterator(int end) {
        this(0, end);
    }

    @Override
    public boolean hasNext() {
        return pointer < end;
    }

    @Override
    public int next() {
        return pointer += advance;
    }

}
