package arch.tools.collection.iterator;

import java.util.Objects;

public final class IntCursor implements IntIterator {

    private final IntIterator intIterator;

    private int currentValue;

    public IntCursor(IntIterator intIterator) {
        this.intIterator = Objects.requireNonNull(intIterator);
    }

    @Override
    public boolean hasNext() {
        return intIterator.hasNext();
    }

    public int getCurrentValue() {
        return currentValue;
    }

    @Override
    public int next() {
        return currentValue = intIterator.next();
    }

}
