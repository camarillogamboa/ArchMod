package arch.tools.collection.iterator;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.Function;

public final class MappedIterator<T, R> implements Iterator<R> {

    private final Iterator<T> iterator;
    private final Function<T, R> function;

    public MappedIterator(Iterator<T> iterator, Function<T, R> function) {
        this.iterator = Objects.requireNonNull(iterator);
        this.function = Objects.requireNonNull(function);
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public R next() {
        return function.apply(iterator.next());
    }

}
