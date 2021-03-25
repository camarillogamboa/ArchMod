package arch.tools.collection.array;

import arch.tools.collection.filler.DoubleFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;
import java.util.function.IntToDoubleFunction;

public final class DoubleArrayFiller extends IndexedIteratorBase implements DoubleFiller {

    private final double[] array;

    public DoubleArrayFiller(double[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(double value) {
        array[intCursor.next()] = value;
    }

    public void fillRemaining(IntToDoubleFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsDouble(i));
    }
}
