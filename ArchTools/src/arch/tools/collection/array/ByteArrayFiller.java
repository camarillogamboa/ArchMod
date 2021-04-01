package arch.tools.collection.array;

import arch.tools.collection.filler.ByteFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;
import arch.tools.function.IntToByteFunction;

import java.util.Objects;

public final class ByteArrayFiller extends IndexedIteratorBase implements ByteFiller {

    private final byte[] array;

    public ByteArrayFiller(byte[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(byte value) {
        array[intCursor.next()] = value;
    }

    public byte[] fillRemaining(IntToByteFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsByte(i));
        return array;
    }

}
