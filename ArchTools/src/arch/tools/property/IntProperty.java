package arch.tools.property;


import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;
import java.util.function.IntUnaryOperator;

public class IntProperty extends ReadOnlyIntProperty implements Prototype<IntProperty> {

    public IntProperty(int value) {
        super(value);
    }

    public IntProperty() {
        super();
    }

    public void set(int value) {
        this.value = value;
    }

    public final void map(IntUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsInt(get()));
    }

    @Override
    public IntProperty cloneThis() {
        return new IntProperty(value);
    }

}
