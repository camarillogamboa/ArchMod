package arch.tools.collection.iterator;

import java.util.Objects;
import java.util.function.IntPredicate;

public final class IndexedBooleanIterator extends IndexedIteratorBase implements BooleanIterator {

    private final IntPredicate elementFunction;

    public IndexedBooleanIterator(int limit, IntPredicate elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public boolean next() {
        return elementFunction.test(intCursor.next());
    }

}
