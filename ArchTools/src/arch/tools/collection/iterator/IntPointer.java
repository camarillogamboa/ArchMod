package arch.tools.collection.iterator;

import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyIntProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class IntPointer implements IntIterator, Flushable {

    private final Pointer<ReadOnlyIntProperty> pointer;

    public IntPointer(IntIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyIntProperty next() {
                return Properties.readOnlyProperty(iterator.next());
            }
        });
    }

    public int getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public int next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public int previus() {
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
