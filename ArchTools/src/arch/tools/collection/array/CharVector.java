package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface CharVector extends ReadOnlyCharVector, Prototype<CharVector> {

    void setValueOf(int index, char value);

    default void setAll(char... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
