package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.FloatIterable;

public interface ReadOnlyFloatVector extends FloatIterable, Sizable {

    float valueOf(int index);

    default float[] toArray() {
        return Arrays.fillerOf(new float[size()]).fillRemaining(this::valueOf);
    }

}
