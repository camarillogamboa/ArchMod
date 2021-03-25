package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableShort;
import arch.tools.function.ShortBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableShortProperty extends ShortProperty implements ObservableShort {

    private final List<ShortBiConsumer> observers;

    public ObservableShortProperty(short value) {
        this.value = value;
        this.observers = new LinkedList<>();
    }

    public ObservableShortProperty() {
        this((short) 0);
    }

    @Override
    public final void addObserver(ShortBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(ShortBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(short value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableShortProperty cloneThis() {
        var newInstance = new ObservableShortProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }

}
