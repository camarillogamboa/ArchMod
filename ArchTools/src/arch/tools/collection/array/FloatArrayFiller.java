package arch.tools.collection.array;

import arch.tools.collection.filler.FloatFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;
import arch.tools.function.IntToFloatFunction;

import java.util.Objects;

public final class FloatArrayFiller extends IndexedIteratorBase implements FloatFiller {

    private final float[] array;

    public FloatArrayFiller(float[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(float value) {
        array[intCursor.next()] = value;
    }

    public void fillRemaining(IntToFloatFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsFloat(i));
    }
}
