package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableInt;
import arch.tools.function.IntBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableIntProperty extends IntProperty implements ObservableInt {

    private final List<IntBiConsumer> observers;

    public ObservableIntProperty(int value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableIntProperty() {
        this(0);
    }

    @Override
    public final void addObserver(IntBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(IntBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(int value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableIntProperty cloneThis() {
        var newInstance = new ObservableIntProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
