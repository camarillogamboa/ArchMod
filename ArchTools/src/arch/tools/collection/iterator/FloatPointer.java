package arch.tools.collection.iterator;

import arch.tools.property.ReadOnlyFloatProperty;

import java.io.Flushable;
import java.util.Iterator;

public final class FloatPointer implements FloatIterator, Flushable {

    private final Pointer<ReadOnlyFloatProperty> pointer;

    public FloatPointer(FloatIterator iterator) {
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyFloatProperty next() {
                return new ReadOnlyFloatProperty(iterator.next());
            }
        });
    }

    public float getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public float next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public float previus() {
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
