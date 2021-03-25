package arch.tools.collection.iterator;

import java.util.Objects;

public final class DoubleCursor implements DoubleIterator {

    private final DoubleIterator doubleIterator;

    private double currentValue;

    public DoubleCursor(DoubleIterator doubleIterator) {
        this.doubleIterator = Objects.requireNonNull(doubleIterator);
    }

    @Override
    public boolean hasNext() {
        return doubleIterator.hasNext();
    }

    public double getCurrentValue() {
        return currentValue;
    }

    @Override
    public double next() {
        return currentValue = doubleIterator.next();
    }

}
