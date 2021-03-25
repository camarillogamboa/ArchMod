package arch.tools.property;

import arch.tools.function.ByteConsumer;
import arch.tools.function.ByteSupplier;

import java.util.Objects;

public class ReadOnlyByteProperty implements NumericalProperty, Comparable<ReadOnlyByteProperty> {

    protected byte value;

    public ReadOnlyByteProperty(byte value) {
        this.value = value;
    }

    public ReadOnlyByteProperty() {
        this((byte) 0);
    }

    public final byte get() {
        return value;
    }

    public final void consume(ByteConsumer consumer) {
        Objects.requireNonNull(consumer);
        consumer.accept(value);
    }

    public final ByteSupplier toSupplier() {
        return this::get;
    }

    @Override
    public final int compareTo(ReadOnlyByteProperty o) {
        return Byte.compare(value, o.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        var that = (ReadOnlyByteProperty) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

}
