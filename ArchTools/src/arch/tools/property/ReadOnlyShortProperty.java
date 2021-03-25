package arch.tools.property;

import arch.tools.function.ShortConsumer;
import arch.tools.function.ShortSupplier;

import java.util.Objects;

public class ReadOnlyShortProperty implements NumericalProperty, Comparable<ReadOnlyShortProperty> {

    protected short value;

    public ReadOnlyShortProperty(short value) {
        this.value = value;
    }

    public ReadOnlyShortProperty() {
        this((short) 0);
    }

    public final short get() {
        return value;
    }

    public final void consume(ShortConsumer consume) {
        Objects.requireNonNull(consume);
        consume.accept(value);
    }

    public final ShortSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyShortProperty o) {
        return Short.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyShortProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
