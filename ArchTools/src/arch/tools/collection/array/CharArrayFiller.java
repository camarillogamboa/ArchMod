package arch.tools.collection.array;

import arch.tools.collection.filler.CharFiller;
import arch.tools.collection.iterator.IndexedIteratorBase;
import arch.tools.collection.iterator.Iterators;
import arch.tools.function.IntToCharFunction;

import java.util.Objects;

public final class CharArrayFiller extends IndexedIteratorBase implements CharFiller {

    private final char[] array;

    public CharArrayFiller(char[] array) {
        super(array.length);
        this.array = array;
    }

    @Override
    public void put(char value) {
        array[intCursor.next()] = value;
    }

    public char[] fillRemaining(IntToCharFunction action) {
        Objects.requireNonNull(action);
        Iterators.iterate(intCursor, i -> array[i] = action.applyAsChar(i));
        return array;
    }

}
