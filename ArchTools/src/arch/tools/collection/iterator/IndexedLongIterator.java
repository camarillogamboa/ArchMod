package arch.tools.collection.iterator;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntToLongFunction;

public final class IndexedLongIterator extends IndexedIteratorBase implements LongIterator {

    private final IntToLongFunction elementFunction;

    public IndexedLongIterator(int limit, IntToLongFunction elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public long next() {
        if (hasNext()) return elementFunction.applyAsLong(intCursor.next());
        else throw new NoSuchElementException();
    }
}
