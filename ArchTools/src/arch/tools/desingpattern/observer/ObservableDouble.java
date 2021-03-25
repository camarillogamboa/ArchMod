package arch.tools.desingpattern.observer;

import arch.tools.function.DoubleBiConsumer;

public interface ObservableDouble {

    void addObserver(DoubleBiConsumer observer);

    void removeObserver(DoubleBiConsumer observer);

}
