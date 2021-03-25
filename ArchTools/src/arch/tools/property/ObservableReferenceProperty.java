package arch.tools.property;

import arch.tools.desingpattern.observer.ObservableReference;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class ObservableReferenceProperty<T> extends ReferenceProperty<T> implements ObservableReference<T> {

    private final List<BiConsumer<? super T, ? super T>> observers;

    public ObservableReferenceProperty(T value) {
        super(value);
        this.observers = new LinkedList<>();
    }

    public ObservableReferenceProperty() {
        this(null);
    }

    @Override
    public final void addObserver(BiConsumer<? super T, ? super T> observer) {
        observers.add(Objects.requireNonNull(observer));
    }

    @Override
    public final void removeObserver(BiConsumer<? super T, ? super T> observer) {
        observers.remove(Objects.requireNonNull(observer));
    }

    @Override
    public final void set(T value) {
        var oldValue = get();
        super.set(value);
        observers.forEach(o -> o.accept(oldValue, value));
    }

    @Override
    public ObservableReferenceProperty<T> cloneThis() {
        var newInstance = new ObservableReferenceProperty<>(value);

        newInstance.observers.addAll(observers);

        return newInstance;
    }
}
