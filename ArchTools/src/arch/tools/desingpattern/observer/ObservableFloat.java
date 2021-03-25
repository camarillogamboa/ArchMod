package arch.tools.desingpattern.observer;

import arch.tools.function.FloatBiConsumer;

public interface ObservableFloat {

    void addObserver(FloatBiConsumer observer);

    void removeObserver(FloatBiConsumer observer);

}
