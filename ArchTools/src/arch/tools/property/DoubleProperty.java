package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;
import java.util.function.DoubleUnaryOperator;

public class DoubleProperty extends ReadOnlyDoubleProperty implements Prototype<DoubleProperty> {

    public DoubleProperty(double value) {
        super(value);
    }

    public DoubleProperty() {
        super();
    }

    public void set(double value) {
        this.value = value;
    }

    public final void map(DoubleUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsDouble(get()));
    }

    @Override
    public DoubleProperty cloneThis() {
        return new DoubleProperty(value);
    }
}
