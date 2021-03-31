package arch.tools.collection.iterator;

import java.util.Iterator;
import java.util.Objects;

public final class Cursor<T> implements Iterator<T> {

    private final Iterator<T> iterator;

    private T currentValue;

    public Cursor(Iterator<T> iterator) {
        this.iterator = Objects.requireNonNull(iterator);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    public T getCurrentValue() {
        return currentValue;
    }

    @Override
    public T next() {
        return currentValue = iterator.next();
    }

}
