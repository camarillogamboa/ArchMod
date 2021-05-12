package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.FloatUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableFloatProperty extends FloatProperty implements Observable<FloatUpdateEvent> {

    private final List<Observer<FloatUpdateEvent>> observers;

    public ObservableFloatProperty(float value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableFloatProperty() {
        this(0);
    }

    @Override
    public final void addObserver(Observer<FloatUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<FloatUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(float value) {
        var oldValue = get();
        super.set(value);
        var event = new FloatUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableFloatProperty cloneThis() {
        var newInstance = new ObservableFloatProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
