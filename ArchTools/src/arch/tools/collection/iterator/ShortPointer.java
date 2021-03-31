package arch.tools.collection.iterator;

import arch.tools.property.ReadOnlyShortProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class ShortPointer implements ShortIterator, Flushable {

    private final Pointer<ReadOnlyShortProperty> pointer;

    public ShortPointer(ShortIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyShortProperty next() {
                return new ReadOnlyShortProperty(iterator.next());
            }
        });
    }

    public short getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public short next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public short previus() {
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
