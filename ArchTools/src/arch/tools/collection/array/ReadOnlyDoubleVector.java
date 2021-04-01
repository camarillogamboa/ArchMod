package arch.tools.collection.array;

import arch.tools.collection.Sizable;
import arch.tools.collection.iterator.DoubleIterable;

public interface ReadOnlyDoubleVector extends DoubleIterable, Sizable {

    double valueOf(int index);

    default double[] toArray() {
        return Arrays.fillerOf(new double[size()]).fillRemaining(this::valueOf);
    }

}
