package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.ShortIterable;

public interface ReadOnlyShortVector extends ShortIterable, Sizable {

    short valueOf(int index);

    default short[] toArray() {
        var array = new short[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
