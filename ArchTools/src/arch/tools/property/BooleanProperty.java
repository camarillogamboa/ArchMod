package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.function.BooleanUnaryOperator;

import java.util.Objects;

public class BooleanProperty extends ReadOnlyBooleanProperty implements Prototype<BooleanProperty> {

    public BooleanProperty(boolean value) {
        super(value);
    }

    public BooleanProperty() {
        super();
    }

    public void set(boolean value) {
        this.value = value;
    }

    public final void map(BooleanUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsBoolean(get()));
    }

    @Override
    public BooleanProperty cloneThis() {
        return new BooleanProperty(value);
    }

}
