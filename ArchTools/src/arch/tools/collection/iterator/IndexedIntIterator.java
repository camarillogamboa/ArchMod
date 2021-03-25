package arch.tools.collection.iterator;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntUnaryOperator;

public final class IndexedIntIterator extends IndexedIteratorBase implements IntIterator {

    private final IntUnaryOperator elementFunction;

    public IndexedIntIterator(int limit, IntUnaryOperator elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public int next() {
        if (hasNext()) return elementFunction.applyAsInt(intCursor.next());
        else throw new NoSuchElementException();
    }
}
