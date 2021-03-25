package arch.tools.property;

import arch.tools.function.FloatConsumer;
import arch.tools.function.FloatSupplier;

import java.util.Objects;

public class ReadOnlyFloatProperty implements NumericalProperty, Comparable<ReadOnlyFloatProperty> {

    protected float value;

    public ReadOnlyFloatProperty(float value) {
        this.value = value;
    }

    public ReadOnlyFloatProperty() {
        this(0);
    }

    public final float get() {
        return value;
    }

    public final void consume(FloatConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final FloatSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyFloatProperty o) {
        return Float.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyFloatProperty) o;
        return Float.compare(that.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
