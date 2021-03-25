package arch.tools.collection.iterator;

public final class LongRangeIterator implements LongIterator {

    private final long end;
    private final long advance;

    private long pointer;

    public LongRangeIterator(long start, long end, long advance) {
        this.end = end;
        this.advance = advance;

        this.pointer = start - advance;
    }

    public LongRangeIterator(long start, long end) {
        this(start, end, 1);
    }

    public LongRangeIterator(long end) {
        this(0, end);
    }

    @Override
    public boolean hasNext() {
        return pointer < end;
    }

    @Override
    public long next() {
        return pointer += advance;
    }

}
