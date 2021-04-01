package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface LongVector extends ReadOnlyLongVector, Prototype<LongVector> {

    void setValueOf(int index, long value);

    default void setAll(long... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
