package arch.tools.collection.array;

import arch.tools.collection.filler.ShortFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;
import arch.tools.function.IntToShortFunction;

import java.util.Objects;

public final class ShortArrayFiller extends IndexedIteratorBase implements ShortFiller {

    private final short[] array;

    public ShortArrayFiller(short[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(short value) {
        array[intCursor.next()] = value;
    }

    public void fillRemaining(IntToShortFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsShort(i));
    }
}
