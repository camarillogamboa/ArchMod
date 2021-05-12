package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.CharUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableCharProperty extends CharProperty implements Observable<CharUpdateEvent> {

    private final List<Observer<CharUpdateEvent>> observers;

    public ObservableCharProperty(char value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableCharProperty() {
        this(' ');
    }

    @Override
    public final void addObserver(Observer<CharUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<CharUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(char value) {
        var oldValue = get();
        super.set(value);
        var event = new CharUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableCharProperty cloneThis() {
        var newInstance = new ObservableCharProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }

}
