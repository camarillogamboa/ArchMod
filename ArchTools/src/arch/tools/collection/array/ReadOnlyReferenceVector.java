package arch.tools.collection.array;

import arch.tools.collection.Sizable;

import java.util.function.IntFunction;

public interface ReadOnlyReferenceVector<E> extends Iterable<E>, Sizable {

    E valueOf(int index);

    default E[] toArray(IntFunction<E[]> factory) {
        return Arrays.fillerOf(factory.apply(size())).fillRemaining(this::valueOf);
    }

}
