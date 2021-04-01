package arch.tools.collection.array;

import arch.tools.collection.filler.BooleanFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;
import java.util.function.IntPredicate;

public final class BooleanArrayFiller extends IndexedIteratorBase implements BooleanFiller {

    private final boolean[] array;

    public BooleanArrayFiller(boolean[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(boolean value) {
        array[intCursor.next()] = value;
    }

    public boolean[] fillRemaining(IntPredicate action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.test(i));
        return array;
    }

}
