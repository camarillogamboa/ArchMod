package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.BooleanIterable;

public interface ReadOnlyBooleanVector extends BooleanIterable, Sizable {

    boolean valueOf(int index);

    default boolean[] toArray() {
        var array = new boolean[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
