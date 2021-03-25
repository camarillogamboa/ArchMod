package arch.tools.collection.iterator;

import arch.tools.property.Properties;
import arch.tools.property.ReadOnlyBooleanProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class BooleanPointer implements BooleanIterator, Flushable {

    private final Pointer<ReadOnlyBooleanProperty> pointer;

    public BooleanPointer(BooleanIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyBooleanProperty next() {
                return Properties.readOnlyProperty(iterator.next());
            }
        });
    }

    public boolean getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public boolean next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public boolean previus() {
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
