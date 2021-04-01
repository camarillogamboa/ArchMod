package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface ShortVector extends ReadOnlyShortVector, Prototype<ShortVector> {

    void setValueOf(int index, short value);

    default void setAll(short... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
