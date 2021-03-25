package arch.tools.property;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ReadOnlyReferenceProperty<T> implements Property, Comparable<ReadOnlyReferenceProperty<T>> {

    protected T value;

    public ReadOnlyReferenceProperty(T value) {
        this.value = value;
    }

    public ReadOnlyReferenceProperty() {
        this(null);
    }

    public final T get() {
        return value;
    }

    public final void consume(Consumer<? super T> consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final Supplier<T> toSupplier() {
        return this::get;
    }

    @Override
    public int compareTo(ReadOnlyReferenceProperty<T> o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyReferenceProperty<?>) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
