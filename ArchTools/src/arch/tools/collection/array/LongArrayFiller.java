package arch.tools.collection.array;

import arch.tools.collection.filler.LongFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;
import java.util.function.IntToLongFunction;

public final class LongArrayFiller extends IndexedIteratorBase implements LongFiller {

    private final long[] array;

    public LongArrayFiller(long[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(long value) {
        array[intCursor.next()] = value;
    }

    public long[] fillRemaining(IntToLongFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsLong(i));
        return array;
    }

}
