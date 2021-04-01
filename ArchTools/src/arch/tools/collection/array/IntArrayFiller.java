package arch.tools.collection.array;

import arch.tools.collection.filler.IntFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

public final class IntArrayFiller extends IndexedIteratorBase implements IntFiller {

    private final int[] array;

    public IntArrayFiller(int[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(int value) {
        array[intCursor.next()] = value;
    }

    public int[] fillRemaining(IntUnaryOperator action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsInt(i));
        return array;
    }
}
