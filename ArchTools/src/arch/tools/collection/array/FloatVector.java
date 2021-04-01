package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface FloatVector extends ReadOnlyFloatVector, Prototype<FloatVector> {

    void setValueOf(int index, float value);

    default void setAll(char... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
