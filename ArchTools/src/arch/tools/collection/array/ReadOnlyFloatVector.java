package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.FloatIterable;

public interface ReadOnlyFloatVector extends FloatIterable, Sizable {

    float valueOf(int index);

    default float[] toArray() {
        var array = new float[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
