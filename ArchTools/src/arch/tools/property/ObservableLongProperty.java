package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.LongUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableLongProperty extends LongProperty implements Observable<LongUpdateEvent> {

    private final List<Observer<LongUpdateEvent>> observers;

    public ObservableLongProperty(long value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableLongProperty() {
        this(0);
    }

    @Override
    public final void addObserver(Observer<LongUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<LongUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(long value) {
        var oldValue = get();
        super.set(value);
        var event = new LongUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableLongProperty cloneThis() {
        var newInstance = new ObservableLongProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
