package arch.tools.collection.iterator;

import java.util.Objects;

public final class ByteCursor implements ByteIterator {

    private final ByteIterator byteIterator;

    private byte currentValue;

    public ByteCursor(ByteIterator byteIterator) {
        this.byteIterator = Objects.requireNonNull(byteIterator);
    }

    @Override
    public boolean hasNext() {
        return byteIterator.hasNext();
    }

    public byte getCurrentValue() {
        return currentValue;
    }

    @Override
    public byte next() {
        return currentValue = byteIterator.next();
    }

}
