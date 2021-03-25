package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;
import arch.tools.function.CharUnaryOperator;

import java.util.Objects;

public class CharProperty extends ReadOnlyCharProperty implements Prototype<CharProperty> {

    public CharProperty(char value) {
        super(value);
    }

    public CharProperty() {
        super();
    }

    public void set(char value) {
        this.value = value;
    }

    public final void map(CharUnaryOperator operator) {
        Objects.requireNonNull(operator);
        set(operator.applyAsChar(get()));
    }

    @Override
    public CharProperty cloneThis() {
        return new CharProperty(value);
    }

}
