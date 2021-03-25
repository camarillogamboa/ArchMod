package arch.tools.property;

import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

public class ReadOnlyIntProperty implements NumericalProperty, Comparable<ReadOnlyIntProperty> {

    protected int value;

    public ReadOnlyIntProperty(int value) {
        this.value = value;
    }

    public ReadOnlyIntProperty() {
        this(0);
    }

    public final int get() {
        return value;
    }

    public final void consume(IntConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final IntSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyIntProperty o) {
        return Integer.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyIntProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
