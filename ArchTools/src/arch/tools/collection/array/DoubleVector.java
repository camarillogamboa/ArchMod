package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface DoubleVector extends ReadOnlyDoubleVector, Prototype<DoubleVector> {

    void setValueOf(int index, double value);

    default void setAll(double... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
