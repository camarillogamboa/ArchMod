package arch.tools.collection.iterator;

import arch.tools.property.ReadOnlyCharProperty;

import java.io.Flushable;
import java.util.Iterator;
import java.util.Objects;

public final class CharPointer implements CharIterator, Flushable {

    private final Pointer<ReadOnlyCharProperty> pointer;

    public CharPointer(CharIterator iterator) {
        Objects.requireNonNull(iterator);
        this.pointer = new Pointer<>(new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ReadOnlyCharProperty next() {
                return new ReadOnlyCharProperty(iterator.next());
            }
        });
    }

    public char getCurrentValue() {
        return pointer.getCurrentValue().get();
    }

    @Override
    public boolean hasNext() {
        return pointer.hasNext();
    }

    @Override
    public char next() {
        return pointer.next().get();
    }

    public boolean hasPrevius() {
        return pointer.hasPrevius();
    }

    public char previus() {
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
