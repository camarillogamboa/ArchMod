package arch.tools.collection.iterator;

import java.util.Objects;

public final class BooleanCursor implements BooleanIterator {

    private final BooleanIterator booleanIterator;

    private boolean currentValue;

    public BooleanCursor(BooleanIterator booleanIterator) {
        this.booleanIterator = Objects.requireNonNull(booleanIterator);
    }

    @Override
    public boolean hasNext() {
        return booleanIterator.hasNext();
    }

    public boolean getCurrentValue() {
        return currentValue;
    }

    @Override
    public boolean next() {
        return currentValue = booleanIterator.next();
    }

}
