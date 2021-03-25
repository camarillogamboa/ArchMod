package arch.tools.collection.iterator;

import arch.tools.function.IntToShortFunction;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class IndexedShortIterator extends IndexedIteratorBase implements ShortIterator {

    private final IntToShortFunction elementFunction;

    public IndexedShortIterator(int limit, IntToShortFunction elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public short next() {
        if (hasNext()) return elementFunction.applyAsShort(intCursor.next());
        else throw new NoSuchElementException();
    }
}
