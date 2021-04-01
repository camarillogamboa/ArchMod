package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.IntIterable;

public interface ReadOnlyIntVector extends IntIterable, Sizable {

    int valueOf(int index);

    default int[] toArray() {
        return Arrays.fillerOf(new int[size()]).fillRemaining(this::valueOf);
    }

}
