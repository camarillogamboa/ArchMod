package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.function.FloatUnaryOperator;

import java.util.Objects;

public class FloatProperty extends ReadOnlyFloatProperty implements Prototype<FloatProperty> {

    public FloatProperty(float value) {
        super(value);
    }

    public FloatProperty() {
        super();
    }

    public void set(float value) {
        this.value = value;
    }

    public final void map(FloatUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsFloat(get()));
    }

    @Override
    public FloatProperty cloneThis() {
        return new FloatProperty(value);
    }
}
