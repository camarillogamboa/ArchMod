package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.BooleanIterable;

public interface ReadOnlyBooleanVector extends BooleanIterable, Sizable {

    boolean valueOf(int index);

    default boolean[] toArray() {
        return Arrays.fillerOf(new boolean[size()]).fillRemaining(this::valueOf);
    }

}
