package arch.tools.desingpattern.observer;

import arch.tools.function.IntBiConsumer;

public interface ObservableInt {

    void addObserver(IntBiConsumer observer);

    void removeObserver(IntBiConsumer observer);

}
