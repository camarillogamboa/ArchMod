package arch.tools.collection.iterator;

import java.util.Iterator;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

public final class IteratorWrapper<E> implements Iterator<E> {

    private final BooleanSupplier booleanSupplier;
    private final Supplier<E> supplier;

    public IteratorWrapper(BooleanSupplier booleanSupplier, Supplier<E> supplier) {
        this.booleanSupplier = Objects.requireNonNull(booleanSupplier);
        this.supplier = Objects.requireNonNull(supplier);
    }

    @Override
    public boolean hasNext() {
        return booleanSupplier.getAsBoolean();
    }

    @Override
    public E next() {
        return supplier.get();
    }
}
