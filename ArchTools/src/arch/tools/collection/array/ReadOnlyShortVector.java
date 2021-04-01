package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.ShortIterable;

public interface ReadOnlyShortVector extends ShortIterable, Sizable {

    short valueOf(int index);

    default short[] toArray() {
        return Arrays.fillerOf(new short[size()]).fillRemaining(this::valueOf);
    }

}
