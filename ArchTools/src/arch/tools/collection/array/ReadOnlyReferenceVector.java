package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.StreamFactory;

import java.util.function.IntFunction;
import java.util.stream.Stream;

public interface ReadOnlyReferenceVector<E> extends Iterable<E>, Sizable {

    E valueOf(int index);

    default E[] toArray(IntFunction<E[]> factory) {
        return Arrays.fillerOf(factory.apply(size())).fillRemaining(this::valueOf);
    }

    default Stream<E> stream() {
        return StreamFactory.streamOf(iterator());
    }

}
