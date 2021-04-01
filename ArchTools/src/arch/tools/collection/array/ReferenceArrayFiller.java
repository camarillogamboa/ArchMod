package arch.tools.collection.array;

import arch.tools.collection.filler.ReferenceFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;

import java.util.Objects;
import java.util.function.IntFunction;

public final class ReferenceArrayFiller<E> extends IndexedIteratorBase implements ReferenceFiller<E> {

    private final E[] array;

    public ReferenceArrayFiller(E[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(E value) {
        array[intCursor.next()] = value;
    }

    public E[] fillRemaining(IntFunction<E> action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.apply(i));
        return array;
    }

}
