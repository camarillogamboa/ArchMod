package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableChar;
import arch.tools.function.CharBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableCharProperty extends CharProperty implements ObservableChar {

    private final List<CharBiConsumer> observers;

    public ObservableCharProperty(char value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableCharProperty() {
        this(' ');
    }

    @Override
    public final void addObserver(CharBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(CharBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(char value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableCharProperty cloneThis() {
        var newInstance = new ObservableCharProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }

}
