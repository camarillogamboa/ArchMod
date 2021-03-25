package arch.tools.collection.iterator;

import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyLongProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class LongPointer implements LongIterator, Flushable {

    private final Pointer<ReadOnlyLongProperty> pointer;

    public LongPointer(LongIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyLongProperty next() {
                return Properties.readOnlyProperty(iterator.next());
            }
        });
    }

    public long getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public long next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public long previus() {
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
