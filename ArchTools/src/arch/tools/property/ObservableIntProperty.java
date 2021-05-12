package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.IntUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableIntProperty extends IntProperty implements Observable<IntUpdateEvent> {

    private final List<Observer<IntUpdateEvent>> observers;

    public ObservableIntProperty(int value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableIntProperty() {
        this(0);
    }

    @Override
    public final void addObserver(Observer<IntUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<IntUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(int value) {
        var oldValue = get();
        super.set(value);
        var event = new IntUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableIntProperty cloneThis() {
        var newInstance = new ObservableIntProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
