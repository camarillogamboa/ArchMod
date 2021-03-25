package arch.tools.desingpattern.observer;

import arch.tools.function.CharBiConsumer;

public interface ObservableChar {

    void addObserver(CharBiConsumer observer);

    void removeObserver(CharBiConsumer observer);

}
