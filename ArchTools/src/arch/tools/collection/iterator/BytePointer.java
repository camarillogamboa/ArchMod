package arch.tools.collection.iterator;

import arch.tools.property.ReadOnlyByteProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class BytePointer implements ByteIterator, Flushable {

    private final Pointer<ReadOnlyByteProperty> pointer;

    public BytePointer(ByteIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyByteProperty next() {
                return new ReadOnlyByteProperty(iterator.next());
            }
        });
    }

    public byte getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public byte next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public byte previus() {
        return pointer.previus().get();
    }

    public void moveToFirst() {
        pointer.moveToFirst();
    }

    public void moveToLast() {
        pointer.moveToLast();
    }

    public void trim() {
        pointer.trim();
    }

    @Override
    public void flush() {
        pointer.flush();
    }

}
