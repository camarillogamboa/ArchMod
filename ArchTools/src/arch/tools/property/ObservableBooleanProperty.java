package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableBoolean;
import arch.tools.function.BooleanBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableBooleanProperty extends BooleanProperty implements ObservableBoolean {

    private final List<BooleanBiConsumer> observers;

    public ObservableBooleanProperty(boolean value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableBooleanProperty() {
        this(false);
    }

    @Override
    public final void addObserver(BooleanBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(BooleanBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(boolean value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableBooleanProperty cloneThis() {
        var newInstance = new ObservableBooleanProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
