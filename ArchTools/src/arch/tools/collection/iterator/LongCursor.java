package arch.tools.collection.iterator;

import java.util.Objects;

public final class LongCursor implements LongIterator {

    private final LongIterator longIterator;

    private long currentValue;

    public LongCursor(LongIterator longIterator) {
        this.longIterator = Objects.requireNonNull(longIterator);
    }

    @Override
    public boolean hasNext() {
        return longIterator.hasNext();
    }

    public long getCurrentValue() {
        return currentValue;
    }

    @Override
    public long next() {
        return currentValue = longIterator.next();
    }

}
