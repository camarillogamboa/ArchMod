package arch.tools.collection.iterator;

import java.util.Objects;

public final class FloatCursor implements FloatIterator {

    private final FloatIterator floatIterator;

    private float currentValue;

    public FloatCursor(FloatIterator floatIterator) {
        this.floatIterator = Objects.requireNonNull(floatIterator);
    }

    @Override
    public boolean hasNext() {
        return floatIterator.hasNext();
    }

    public float getCurrentValue() {
        return currentValue;
    }

    @Override
    public float next() {
        return currentValue = floatIterator.next();
    }

}
