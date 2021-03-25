package arch.tools.collection.array;

import arch.tools.collection.Sizable;

import java.util.function.IntFunction;

public interface ReadOnlyReferenceVector<E> extends Iterable<E>, Sizable {

    E valueOf(int index);

    default E[] toArray(IntFunction<E[]> factory) {
        var array = factory.apply(size());
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
