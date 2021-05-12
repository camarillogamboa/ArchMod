package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.ShortUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableShortProperty extends ShortProperty implements Observable<ShortUpdateEvent> {

    private final List<Observer<ShortUpdateEvent>> observers;

    public ObservableShortProperty(short value) {
        this.value = value;
        this.observers = new LinkedList<>();
    }

    public ObservableShortProperty() {
        this((short) 0);
    }

    @Override
    public final void addObserver(Observer<ShortUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<ShortUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(short value) {
        var oldValue = get();
        super.set(value);
        var event = new ShortUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableShortProperty cloneThis() {
        var newInstance = new ObservableShortProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }

}
