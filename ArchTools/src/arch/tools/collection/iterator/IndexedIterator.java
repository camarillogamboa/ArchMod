package arch.tools.collection.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.IntFunction;

public final class IndexedIterator<E> extends IndexedIteratorBase implements Iterator<E> {

    private final IntFunction<E> elementFunction;

    public IndexedIterator(int limit, IntFunction<E> elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public E next() {
        if (hasNext()) return elementFunction.apply(intCursor.next());
        else throw new NoSuchElementException();
    }
}
