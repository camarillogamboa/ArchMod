package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.IntIterable;

public interface ReadOnlyIntVector extends IntIterable, Sizable {

    int valueOf(int index);

    default int[] toArray() {
        var array = new int[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
