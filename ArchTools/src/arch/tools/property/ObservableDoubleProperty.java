package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.DoubleUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableDoubleProperty extends DoubleProperty implements Observable<DoubleUpdateEvent> {

    private final List<Observer<DoubleUpdateEvent>> observers;

    public ObservableDoubleProperty(double value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableDoubleProperty() {
        this(0);
    }

    @Override
    public final void addObserver(Observer<DoubleUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<DoubleUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(double value) {
        var oldValue = get();
        super.set(value);
        var event = new DoubleUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableDoubleProperty cloneThis() {
        var newInstance = new ObservableDoubleProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
