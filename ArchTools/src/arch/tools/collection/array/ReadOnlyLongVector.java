package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.LongIterable;

public interface ReadOnlyLongVector extends LongIterable, Sizable {

    long valueOf(int index);

    default long[] toArray() {
        return Arrays.fillerOf(new long[size()]).fillRemaining(this::valueOf);
    }

}
