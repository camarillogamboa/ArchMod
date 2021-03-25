package arch.tools.collection.iterator;

import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyDoubleProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class DoublePointer implements DoubleIterator, Flushable {

    private final Pointer<ReadOnlyDoubleProperty> pointer;

    public DoublePointer(DoubleIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyDoubleProperty next() {
                return Properties.readOnlyProperty(iterator.next());
            }
        });
    }

    public double getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public double next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public double previus() {
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
