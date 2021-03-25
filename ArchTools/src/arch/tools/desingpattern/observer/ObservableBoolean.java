package arch.tools.desingpattern.observer;

import arch.tools.function.BooleanBiConsumer;

public interface ObservableBoolean {

    void addObserver(BooleanBiConsumer observer);

    void removeObserver(BooleanBiConsumer observer);

}
