package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableFloat;
import arch.tools.function.FloatBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableFloatProperty extends FloatProperty implements ObservableFloat {

    private final List<FloatBiConsumer> observers;

    public ObservableFloatProperty(float value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableFloatProperty() {
        this(0);
    }

    @Override
    public final void addObserver(FloatBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(FloatBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(float value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableFloatProperty cloneThis() {
        var newInstance = new ObservableFloatProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
