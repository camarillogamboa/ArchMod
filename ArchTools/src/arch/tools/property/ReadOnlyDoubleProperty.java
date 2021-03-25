package arch.tools.property;

import java.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleSupplier;

public class ReadOnlyDoubleProperty implements NumericalProperty, Comparable<ReadOnlyDoubleProperty> {

    protected double value;

    public ReadOnlyDoubleProperty(double value) {
        this.value = value;
    }

    public ReadOnlyDoubleProperty() {
        this(0);
    }

    public final double get() {
        return value;
    }

    public final void consume(DoubleConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final DoubleSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyDoubleProperty o) {
        return Double.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyDoubleProperty) o;
        return Double.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
