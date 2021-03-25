package arch.tools.desingpattern.observer;

import arch.tools.function.ShortBiConsumer;

public interface ObservableShort {

    void addObserver(ShortBiConsumer observer);

    void removeObserver(ShortBiConsumer observer);

}
