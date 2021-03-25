package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.function.ByteUnaryOperator;

import java.util.Objects;

public class ByteProperty extends ReadOnlyByteProperty implements Prototype<ByteProperty> {

    public ByteProperty(byte value) {
        super(value);
    }

    public ByteProperty() {
        super();
    }

    public void set(byte value) {
        this.value = value;
    }

    public final void map(ByteUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsByte(get()));
    }

    @Override
    public ByteProperty cloneThis() {
        return new ByteProperty(value);
    }

}
