package arch.tools.desingpattern.observer;

import java.util.function.BiConsumer;

public interface ObservableReference<T> {

    void addObserver(BiConsumer<? super T, ? super T> observer);

    void removeObserver(BiConsumer<? super T, ? super T> observer);

}
