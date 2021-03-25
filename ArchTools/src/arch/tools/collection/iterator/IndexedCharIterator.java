package arch.tools.collection.iterator;

import arch.tools.function.IntToCharFunction;

import java.util.NoSuchElementException;
import java.util.Objects;

public final class IndexedCharIterator extends IndexedIteratorBase implements CharIterator {

    private final IntToCharFunction elementFunction;

    public IndexedCharIterator(int limit, IntToCharFunction elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public char next() {
        if (hasNext()) return elementFunction.applyAsChar(intCursor.next());
        else throw new NoSuchElementException();
    }

}
