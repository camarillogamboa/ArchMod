package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableDouble;
import arch.tools.function.DoubleBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableDoubleProperty extends DoubleProperty implements ObservableDouble {

    private final List<DoubleBiConsumer> observers;

    public ObservableDoubleProperty(double value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableDoubleProperty() {
        this(0);
    }

    @Override
    public final void addObserver(DoubleBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(DoubleBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(double value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableDoubleProperty cloneThis() {
        var newInstance = new ObservableDoubleProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
