package arch.tools.collection.iterator;

import arch.tools.function.IntToByteFunction;

import java.util.Objects;

public final class IndexedByteIterator extends IndexedIteratorBase implements ByteIterator {

    private final IntToByteFunction elementFunction;

    public IndexedByteIterator(int limit, IntToByteFunction elementFunction) {
        super(limit);
        this.elementFunction = Objects.requireNonNull(elementFunction);
    }

    @Override
    public byte next() {
        return elementFunction.applyAsByte(intCursor.next());
    }

}
