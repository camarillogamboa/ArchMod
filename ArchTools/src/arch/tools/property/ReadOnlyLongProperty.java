package arch.tools.property;

import java.util.Objects;
import java.util.function.LongConsumer;
import java.util.function.LongSupplier;

public class ReadOnlyLongProperty implements NumericalProperty, Comparable<ReadOnlyLongProperty> {

    protected long value;

    public ReadOnlyLongProperty(long value) {
        this.value = value;
    }

    public ReadOnlyLongProperty() {
        this(0);
    }

    public final long get() {
        return value;
    }

    public final void consume(LongConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final LongSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyLongProperty o) {
        return Long.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyLongProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
