package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.CharIterable;

public interface ReadOnlyCharVector extends CharIterable, Sizable {

    char valueOf(int index);

    default char[] toArray() {
        var array = new char[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
