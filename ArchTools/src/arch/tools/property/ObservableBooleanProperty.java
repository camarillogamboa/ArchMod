package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.BooleanUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableBooleanProperty extends BooleanProperty implements Observable<BooleanUpdateEvent> {

    private final List<Observer<BooleanUpdateEvent>> observers;

    public ObservableBooleanProperty(boolean value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableBooleanProperty() {
        this(false);
    }

    @Override
    public final void addObserver(Observer<BooleanUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<BooleanUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(boolean value) {
        var oldValue = get();
        super.set(value);
        var event = new BooleanUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableBooleanProperty cloneThis() {
        var newInstance = new ObservableBooleanProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
