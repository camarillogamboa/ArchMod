package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableByte;
import arch.tools.function.ByteBiConsumer;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ObservableByteProperty extends ByteProperty implements ObservableByte {

    private final List<ByteBiConsumer> observers;

    public ObservableByteProperty(byte value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableByteProperty() {
        this((byte) 0);
    }

    @Override
    public final void addObserver(ByteBiConsumer observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(ByteBiConsumer observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(byte value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableByteProperty cloneThis() {
        var newInstance = new ObservableByteProperty(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
