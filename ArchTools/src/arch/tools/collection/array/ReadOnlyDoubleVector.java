package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.DoubleIterable;

public interface ReadOnlyDoubleVector extends DoubleIterable, Sizable {

    double valueOf(int index);

    default double[] toArray() {
        var array = new double[size()];
        Arrays.filler(array).fillRemaining(this::valueOf);
        return array;
    }

}
