package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.ReferenceUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableReferenceProperty<T> extends ReferenceProperty<T> implements Observable<ReferenceUpdateEvent<? super T>> {

    private final List<Observer<ReferenceUpdateEvent<? super T>>> observers;

    public ObservableReferenceProperty(T value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableReferenceProperty() {
        this(null);
    }

    @Override
    public final void addObserver(Observer<ReferenceUpdateEvent<? super T>> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<ReferenceUpdateEvent<? super T>> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(T value) {
        var oldValue = get();
        super.set(value);
        var event = new ReferenceUpdateEvent<T>(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableReferenceProperty<T> cloneThis() {
        var newInstance = new ObservableReferenceProperty<>(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
