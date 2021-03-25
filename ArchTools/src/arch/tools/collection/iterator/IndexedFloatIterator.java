package arch.tools.collection.iterator;

import arch.tools.function.IntToFloatFunction;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class IndexedFloatIterator extends IndexedIteratorBase implements FloatIterator {

    private final IntToFloatFunction elementFunction;

    public IndexedFloatIterator(int limit, IntToFloatFunction elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public float next() {
        if (hasNext()) return elementFunction.applyAsFloat(intCursor.next());
        else throw new NoSuchElementException();
    }
}
