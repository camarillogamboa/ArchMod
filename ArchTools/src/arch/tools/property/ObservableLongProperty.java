package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableLong;
import arch.tools.function.LongBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableLongProperty extends LongProperty implements ObservableLong {

    private final List<LongBiConsumer> observers;

    public ObservableLongProperty(long value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableLongProperty() {
        this(0);
    }

    @Override
    public final void addObserver(LongBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(LongBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(long value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableLongProperty cloneThis() {
        var newInstance = new ObservableLongProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
