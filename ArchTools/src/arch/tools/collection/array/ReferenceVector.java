package arch.tools.collection.array;

import arch.tools.desingpattern.prototype.Prototype;

public interface ReferenceVector<E> extends ReadOnlyReferenceVector<E>, Prototype<ReferenceVector<E>> {

    void setValueOf(int index, E value);

    default void setAll(E... elements) {
        var limit = Math.min(size(), elements.length);

        for (int i = 0; i < limit; i++) setValueOf(i, elements[i]);

    }

}
