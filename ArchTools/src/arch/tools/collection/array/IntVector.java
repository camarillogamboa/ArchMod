package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface IntVector extends ReadOnlyIntVector, Prototype<IntVector> {

    void setValueOf(int index, int value);

    default void setAll(int... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
