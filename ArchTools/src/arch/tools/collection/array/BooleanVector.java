package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface BooleanVector extends ReadOnlyBooleanVector, Prototype<BooleanVector> {

    void setValueOf(int index, boolean value);

    default void setAll(boolean... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
