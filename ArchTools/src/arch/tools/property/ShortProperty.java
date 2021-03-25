package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.function.ShortUnaryOperator;

import java.util.Objects;

public class ShortProperty extends ReadOnlyShortProperty implements Prototype<ShortProperty> {

    public ShortProperty(short value) {
        super(value);
    }

    public ShortProperty() {
        super();
    }

    public void set(short value) {
        this.value = value;
    }

    public final void map(ShortUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsShort(get()));
    }

    @Override
    public ShortProperty cloneThis() {
        return new ShortProperty(value);
    }

}
