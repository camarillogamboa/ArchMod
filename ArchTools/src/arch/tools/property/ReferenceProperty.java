package arch.tools.property;

import arch.tools.desingpattern.prototype.Prototype;

import java.util.Objects;
import java.util.function.UnaryOperator;

public class ReferenceProperty<T> extends ReadOnlyReferenceProperty<T> implements Prototype<ReferenceProperty<T>> {

    public ReferenceProperty(T value) {
        super(value);
    }

    public ReferenceProperty() {
        super();
    }

    public void set(T value) {
        this.value = value;
    }

    public final void map(UnaryOperator<T> operator) {
        Objects.requireNonNull(operator);
        set(operator.apply(get()));
    }

    @Override
    public ReferenceProperty<T> cloneThis() {
        return new ReferenceProperty<>(value);
    }
}
