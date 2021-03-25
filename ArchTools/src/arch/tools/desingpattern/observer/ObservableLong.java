package arch.tools.desingpattern.observer;

import arch.tools.function.LongBiConsumer;

public interface ObservableLong {

    void addObserver(LongBiConsumer observer);

    void removeObserver(LongBiConsumer observer);

}
