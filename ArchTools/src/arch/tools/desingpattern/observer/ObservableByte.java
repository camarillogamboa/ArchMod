package arch.tools.desingpattern.observer;

import arch.tools.function.ByteBiConsumer;

public interface ObservableByte {

    void addObserver(ByteBiConsumer observer);

    void removeObserver(ByteBiConsumer observer);

}
