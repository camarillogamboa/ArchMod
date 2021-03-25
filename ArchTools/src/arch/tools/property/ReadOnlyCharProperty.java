package arch.tools.property;

import arch.tools.function.CharConsumer;
import arch.tools.function.CharSupplier;

import java.util.Objects;

public class ReadOnlyCharProperty implements Property, Comparable<ReadOnlyCharProperty> {

    protected char value;

    public ReadOnlyCharProperty(char value) {
        this.value = value;
    }

    public ReadOnlyCharProperty() {
        this(' ');
    }

    public final char get() {
        return value;
    }

    public final void consume(CharConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final CharSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyCharProperty o) {
        return Character.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyCharProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
