package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;
import java.util.function.LongUnaryOperator;

public class LongProperty extends ReadOnlyLongProperty implements Prototype<LongProperty> {

    public LongProperty(long value) {
        super(value);
    }

    public LongProperty() {
        super();
    }

    public void set(long value) {
        this.value = value;
    }

    public final void map(LongUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsLong(get()));
    }

    @Override
    public LongProperty cloneThis() {
        return new LongProperty(value);
    }
}
