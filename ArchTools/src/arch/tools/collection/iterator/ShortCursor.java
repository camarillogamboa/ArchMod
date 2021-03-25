package arch.tools.collection.iterator;

import java.util.Objects;

public final class ShortCursor implements ShortIterator {

    private final ShortIterator shortIterator;

    private short currentValue;

    public ShortCursor(ShortIterator shortIterator) {
        this.shortIterator = Objects.requireNonNull(shortIterator);
    }

    @Override
    public boolean hasNext() {
        return shortIterator.hasNext();
    }

    public short getCurrentValue() {
        return currentValue;
    }

    @Override
    public short next() {
        return currentValue = shortIterator.next();
    }

}
