package arch.tools.collection.iterator;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntToDoubleFunction;

public final class IndexedDoubleIterator extends IndexedIteratorBase implements DoubleIterator {

    private final IntToDoubleFunction elementfunction;

    public IndexedDoubleIterator(int limit, IntToDoubleFunction elementfunction) {
        super(limit);
        this.elementfunction = Objects.requireNonNull(elementfunction);
    }

    @Override
    public double next() {
        if (hasNext()) return elementfunction.applyAsDouble(intCursor.next());
        else throw new NoSuchElementException();
    }

}
