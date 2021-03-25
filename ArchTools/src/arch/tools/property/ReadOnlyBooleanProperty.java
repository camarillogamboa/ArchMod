package arch.tools.property;

import arch.tools.function.BooleanConsumer;

import java.util.Objects;
import java.util.function.BooleanSupplier;

public class ReadOnlyBooleanProperty implements Property, Comparable<ReadOnlyBooleanProperty> {

    protected boolean value;

    public ReadOnlyBooleanProperty(boolean value) {
        this.value = value;
    }

    public ReadOnlyBooleanProperty() {
        this(false);
    }

    public final boolean get() {
        return value;
    }

    public final void consume(BooleanConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final BooleanSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyBooleanProperty o) {
        return Boolean.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyBooleanProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
