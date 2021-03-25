package arch.tools.collection;

import java.util.Collection;
import java.util.Objects;
import java.util.function.IntFunction;

public interface AbstractCollection<E> extends Collection<E>, Sizable, Cleanable {

    @Override
    default boolean isEmpty() {
        return Sizable.super.isEmpty();
    }

    default boolean addAll(E... array) {
        boolean modified = false;
        for (E e : array) if (add(e)) modified = true;
        return modified;
    }

    @Override
    default boolean addAll(Collection<? extends E> c) {
        Objects.requireNonNull(c);
        boolean modified = false;
        for (E e : c) if (add(e)) modified = true;
        return modified;
    }

    @Override
    default boolean remove(Object o) {
        return removeIf(value -> value != null && value.equals(o) || value == o);
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        Objects.requireNonNull(c);
        c.forEach(this::remove);
        return true;
    }

    default boolean contains(Object o) {
        var it = iterator();
        if (o == null) while (it.hasNext()) if (it.next() == null) return true;
        else while (it.hasNext()) if (o.equals(it.next())) return true;
        return false;
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c);
        for (Object o : c) if (!contains(o)) return false;
        return true;
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    default E[] toArray() {
        var e = (E[]) new Object[size()];
        var iterator = iterator();
        for (int i = 0; i < e.length; i++) e[i] = iterator.next();
        return e;
    }

    @Override
    default <T> T[] toArray(T[] a) {
        Objects.requireNonNull(a);
        if (a.length >= size()) {
            var iterator = iterator();
            for (int i = 0; i < size(); i++) a[i] = (T) iterator.next();
        }
        return a;
    }

    @Override
    default <T> T[] toArray(IntFunction<T[]> generator) {
        Objects.requireNonNull(generator);
        return toArray(generator.apply(size()));
    }

}
