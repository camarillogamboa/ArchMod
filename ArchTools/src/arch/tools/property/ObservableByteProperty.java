package arch.tools.property;

import arch.tools.desingpattern.observer.Observable;
import arch.tools.desingpattern.observer.Observer;
import arch.tools.desingpattern.observer.event.ByteUpdateEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableByteProperty extends ByteProperty implements Observable<ByteUpdateEvent> {

    private final List<Observer<ByteUpdateEvent>> observers;

    public ObservableByteProperty(byte value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableByteProperty() {
        this((byte) 0);
    }

    @Override
    public final void addObserver(Observer<ByteUpdateEvent> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(Observer<ByteUpdateEvent> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(byte value) {
        var oldValue = get();
        super.set(value);
        var event = new ByteUpdateEvent(this, oldValue, value);
        observers.forEach(o -> o.update(event));
    }

    @Override
    public ObservableByteProperty cloneThis() {
        var newInstance = new ObservableByteProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
